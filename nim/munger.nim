import os, parsecsv, streams

let
  path = paramStr(1)

echo("Got path: ", path)

var strm = newFileStream(path, fmRead)

var parser: CsvParser
open(parser, strm, path)

var rowsRead = 0

while rowsRead < 5:
  discard readRow(parser)
  rowsRead += 1
  echo "\t", parser.row


echo rowsRead
