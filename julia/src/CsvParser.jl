module CsvCleanup

using TimeZones
using DataFrames

pn_re = r"\d-(\d{3})-(\d{3})-(\d{4})|(\d{3})\.(\d{3})\.(\d{4})|\((\d{3})\) (\d{3})-(\d{4})"

iso_date_fmt = Dates.DateFormat("yyyy-mm-dd")
iso_date_time_fmt = Dates.DateFormat("yyyy-mm-ddTHH:MM:SS")
# Fri, 29 Jul 2016 08:17:24 +0000
rfc822_fmt = Dates.DateFormat("eee, dd uuu yyyy HH:MM:SS zzzz")

function parse_phone_number(pn_str)
    caps = filter(x -> !is(nothing, x), match(pn_re, pn_str).captures)
    join(caps, "-")
end

function parse_date(date_str)
    if ismatch(r"[A-Za-z]{3}", date_str)
        date = ZonedDateTime(date_str, rfc822_fmt)
    elseif contains(date_str, "T")
        date = DateTime(date_str, iso_date_time_fmt)
    else
        date = Date(date_str, iso_date_fmt)
    end
    Dates.format(date, iso_date_fmt)
end

function parse_line(line)
    date_str, pn_str = split(line, '|')
    parsed_dt = parse_date(date_str)
    parsed_pn = parse_phone_number(pn_str)
    [parsed_dt, parsed_pn]
end

function clean_file(in_path)
    in_handle = open(in_path, "r")
    out_handle = open("/tmp/parsed.csv", "a")

    for line in eachline(in_handle)
        new_line = join(parse_line(line), ',') * "\n"
        write(out_handle, new_line)
    end
end

function clean_file_df(in_path)
    DataFrames.readtable(in_path, separator = "|")
end



function count_lines(path)
    counter = 0
    handle = open(path, "r")

    for line in eachline(handle)
        counter += 1

    end

    counter
end


function __init__()
    path = "/Users/rossdonaldson/Code/personal/language-tour/data-generator/2017-05-24_random_data.csv"
    print("Cleaning the file!\n")
    clean_file(path)
    print("All done!")
end

end
