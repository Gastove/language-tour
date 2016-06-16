import times

# Need to parse:
# Thu, 16 Jun 2016 04:16:41 +0000
# 2016-06-16T04:16:41
# 2016-06-16

let
  formats = @["ddd, dd mmmm hh:MM:ss zzzz"]
  parsed = parse("Thu, 16 Jun 2016 04:16:41 +0700", "ddd, dd MMM yyyy hh:mm:ss zz")

  # Boy, that sure just cannot handle an offset without a colon.
  # Welp.
echo format(parsed, "ZZZ")

# echo parse("Thu, 16 Jun 2016 04:16:41 +0000", "ddd, dd MMMM hh:mm:ss zzzz")
