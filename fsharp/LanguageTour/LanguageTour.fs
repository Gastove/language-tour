module LanguageTour

#if INTERACTIVE
#r @"/Users/gastove/Code/language-tour/fsharp/LanguageTour/bin/Debug/FSharp.Data.dll"
#else
open FSharp.Data
#endif

open System.Text.RegularExpressions

[<Literal>]
let csvPath = "/Users/gastove/Code/language-tour/data-generator/2016-06-16_random_data.csv"
[<Literal>]
let inputSep = "|"

let pnRe = @"[1-]?\(?(\d{3})\)?[\. -]?(\d{3})[\.-]?(\d{4})"
let outputFile = "result.csv"
let outputSep = ","

type PhoneNumber =
    {AreaCode: string;
     FirstThree: string;
     LastFour: string}
    override m.ToString() =
        m.AreaCode + "-" + m.FirstThree + "-" + m.LastFour

let listToPn (lst: string list) =
    {AreaCode = lst.[0];
     FirstThree = lst.[1];
     LastFour = lst.[2]}

let parsePn re str =
    let m = Regex(re).Match(str)
    if m.Success
    then Some (listToPn (List.tail [ for x in m.Groups -> x.Value ]))
    else None

type DemoRecord = CsvProvider<csvPath, inputSep, Schema="CsvDate, PhoneNumber">

let data = DemoRecord.Load(csvPath)

// Make sure it's on.
// let firstRow = data.Rows |> Seq.head
// let firstDate = firstRow.CsvDate
// let firstPn = firstRow.PhoneNumber

// Count all the rows in the file
// This is the slowest part by many orders of magnitude
// let numRows = ref 0
// for row in data.Rows do
//     numRows := !numRows + 1

// More testing -- sample the data and print a row in an easy-to-error-check format
// let subset = data.Rows |> Seq.take 50
// let rowToString (row: DemoRecord.Row) =
//     let d = row.CsvDate
//     let pn = row.PhoneNumber
//     d.ToString("yyyy-MM-dd") + " -- " + pn

let rowToCsvRow sep (row: DemoRecord.Row) =
    let pn =
        match (parsePn pnRe row.PhoneNumber) with
        | Some(p) -> sprintf "%O" p
        | None -> "na"
    let dtstr = row.CsvDate.ToString("yyyy-MM-dd HH:mm:ss")
    sprintf "%s%s%s" dtstr sep pn


// [<EntryPoint>]
// let main argv =
//     use writer = new System.IO.StreamWriter(outputFile)
//     for row in data.Rows do
//         row |> rowToCsvRow outputSep |> writer.WriteLine
//     0 // return an integer exit code
