# Hello There

So I've been thinking a lot about programming languages. I've gotten a little stuck, you see, because I do not feel like I've met the Best Language for Me. And what would it even mean if I had? "Best" is a difficult idea at the best (erk) of times, and besides &#x2013; in this bold world of software, aren't we all supposed to be polyglot "full stack" computer do-ers? Right language for the right task?

Waugh.

This repo, such as it is, is my attempt to think through what I want out of a language, or set of languages. Maybe it will also be useful to you? Here's to hope.


# "For"-ness

When I first started programming, I asked programmers of my acquaintance, "so what is <language name> for?" This had decidedly mixed results. A Perl programmer told me, "but what is any language *for*? Programming, obviously." A PHP developer once asserted to me that the only language you *really* needed to care about was PHP. I met a Java developer who told me Java was "for" replacing C++.<sup><a id="fnr.1" class="footref" href="#fn.1">1</a></sup>

I gave up on this question for a very long time, but I've come back to it. A grounding anecdote: I used to work at a very good hardware store, where I was, briefly, responsible for the hammer aisle. We sold 112 different hammers *for nails*, and another 38 *not* for nails. The "for nails" category subdivided in a couple different ways &#x2013; for instance, the wide category of hammers for framing carpentry, typically distinguished by a heavier hammer head and longer shaft. In framing carpentry, you hit a *lot* of nails. Speed &#x2013; being able to drive a very large nail home with one strike &#x2013; is prized over precision; damage to the underlying lumber will be covered up by layers of finishing materials, so who cares if you drive the nail slightly too deep.

A framing hammer is "for" framing. Is that the only thing you can do with it? No. Is a framing hammer the only kind of hammer you can frame with? Again, no. But if you are about to do some framing and thinking, "what kind of hammer should I get", the answer is definitely "framing hammer".

R is "for" statistical programming and analysis. Can you do other stuff with it? Yes, definitely. JavaScript is "for" programming in the browser. Can you do an astonishing amount of other stuff with it? Yes, of course you can. In fact, increasingly, JavaScript seems to be becoming "for" making interfaces to much more complex systems.<sup><a id="fnr.2" class="footref" href="#fn.2">2</a></sup> When I ask programmers what their favorite language is "for", I feel like what they're hearing is some kind of insult or limit &#x2013; as though I want to put Java in a box labeled "use only for X", as though I'm diminishing Java by saying "this is good for one thing." Not so. Good design is about knowing limits and acknowledging them. In my desire to be a capable modern developer, I want to know which tools to reach for, and when.


# Developing a notion of "best"

"Best" is a messy, contextual idea. The first point of context here is called "Ross Donaldson". I am full of opinions about what I think makes a good programming language, and this project is fundamentally about satisfying myself. Any pronouncements of quality are **entirely** within the context of how well I, personally, am getting along with a language. For instance: I cannot abide Java. Incredible things are built in Java every day, and I have a lot of respect for Java developers, and if I never wrote another line of it I'd be happier.

I think a lot of the "goodness" of a language, honestly, comes down to how a given developers thinks. Almost like poetry or fiction &#x2013; what makes sense to you? What makes your brain light up and get happy? I don't find C-style syntax to be particularly nice; I prefer prefix notation, and love lisps. I'm trying to be very laid back about this; I'd love to meet a new language that surprises and delights me.

After rather a good deal of introspection, here's what I've been able to quantify about language goodness, for me:


## Important to me:


### Expressive

I overwhelmingly prefer concise to verbose. Scala is vastly preferable to Java in my eyes, and Clojure is even better. I'm not interested in hundreds of lines of ceremony just to create or assign a new variable. I don't want to build a new class just to define and call a function. Thanks.


### Functional

For a lot of reasons, I vastly prefer my languages functional. I find classes to be an unwieldy abstraction in most cases, and if I can't pass or return a function in a language I'm just not interested. I would always rather write a system of verbs than a system of nouns.


### Typed

I'm alarmed to admit that I like type systems. My favorite type systems do rather a lot of inference; the very nicest are entirely optional. Type systems *can* be an awful drawback for a language; much as I enjoy Scala, the type system&#x2026; can be much, much too heavy.

I'd love to find a language with either a static or gradual type system. I don't care if it enters the runtime, but I'd love to be able to document the inputs and outputs of a function clearly.


### Run-Time

A language needs to have a run-time that matches its use case. Clojure is, for me, the essential example. To run Clojure, one must run a JVM. If one is writing an application &#x2013; say, a web server &#x2013; the five-or-maybe-a-hundred seconds it takes to spin up even a modest JVM is just fine. But if you've written a CLI, those seconds are intolerable &#x2013; not to mention the outrageous resource requirements. Imagine if `grep` took 40 seconds and a gig of RAM to run on even the tiniest files. Yeah.


### Approximately as high level as possible

You know what I never ever want to do if I don't have to? Manual memory management. In fact, there's a tremendous list of problems, of wheels that I do not want to have to re-invent. Writing my own CSV parser. Performing `GET` requests. *Ugh*. But also, in some sense this idea captures for me the notion of a rich standard library. I mean, I *could* implement my own socket handling, TCP/IP, web sockets, etc &#x2013; but in most cases, I'd really rather not.


### Solidly Usable in my Workflow

I already write a lot of code. I'm in Emacs all day, every day, unless I'm in my terminal. Learning new build tools or package managers is expected; learning a new IDE is not.


### First-class documentation

Docs are so, so, so important, and they belong with your source code, not in some external vault. First class support for documentation strings (a la Clojure and Python) is, in my opinion, nearly indispensable. If you don't have some docstring mechanism, you'd better have something else nice.


### Comprehensible tooling

It's at this point that I start fearing I'm asking for Too Much, but it's important: the tooling and ecosystem around a language shapes a huge amount of your experience of that language. Python packaging? Awful. And tell me: what's the *right* way to package JavaScript? Java does very well here &#x2013; you could use maven or gradle or ant *and they will all work just fine*. In the world in which I would like to live, languages will have decent tools available &#x2013; linters and whatever build tools are needed. I would like that.


### Actively Maintained

At this point, I don't have the wherewithal to write my own language or contribute to the maintenance of one myself. Using something with a community behind it is a must.


### REPL

God I adore having a REPL or interactive session available.


## Nice if I can get it:


### Performant

Who doesn't love a thing that doesn't take all day to run?


### Concurrency Model

Manually starting threads is great and all, but we can do a <span class="underline">lot</span> better. Actor model? Agent model? Sensible message passing implementation?


### Clear

I adore it when a language isn't hard to understand even if you don't speak it. Consider:

```python
for x in range(10):
    print(x**x)
```

You might not know all the fussy little python details about that block without learning them, but it's not hard to apprehend what it's up to.


### Portable

This is an odd one for me, because I don't generally write software that gets distributed on my own time. And yet: I still care about it. I don't feel overly concerned if, say, someone has to install an easily-available piece of software to run my code. But if the setup to get the code running at all is convoluted, I'm not even going to want to do it on my own two computers.


### FFI

Maybe the most optional single thing on here, but dang it'd be handy to have a clear way to do FFI.


# So where am I starting?

I think of myself as a Clojure developer. I've written a lot of Scala and a lot of Python and a mid-sized pile of Java. I like JVMs just fine for running applications and a lot less for CLIs and scripting. Most of my CLI writing so far has been in Python or R. Python is&#x2026; good, but doesn't delight me. (Packaging is awful and it's Just Too Imperative).

One way or the other, I feel like I've got a lovely application language (Clojure), but lack a compelling scripting and CLI language.


# How Evaluation Formed?

So I want a good CLI language. Now what?

My intention is to try writing three little programs in each of a small pile of languages, and see what the experience is like. What's testing like? How onerous is documentation? Is the thing awful to install or run? Note that I'm a professional data-wrangler, so these scripts capture common tasks for me.

For each language, I'll try to write:

1.  Summarize a CSV &#x2013; sum a column, summary statistics, something like that
2.  Hit a REST API and handle the result
3.  Munge date-times and phone numbers in a CSV &#x2013; for instance, converting a non-ISO format to ISO, or parsing milli timestamps

And I'll try to wrap each set of three in a little CLI, for argument parsing and flag handling. We'll see how far I get; the point is to evaluate a language, so if I find disagreeable parts early, I'll probably just&#x2026; stop.

I don't have any particular system in mind for deciding which languages to do this with. Some things, like a language being imperative, usually wont stop me from trying things out; other things, like awful documentation, might. To be honest, I'm also unlikely to spend much time on any language my editor cant easily provide basic syntax highlighting and indentation support for &#x2013; but my editor is Emacs so I should, for the most part, be OK.


## Reference Implementation

I've also knocked together a reference implementation in Clojure. I want to use this to reference a couplefew things:

1.  How much code does it take to get some of these things done in other languages?
2.  How fast do other languages run compared to what I'm used to on the JVM?

A weird note: in my reference impl, I use a wrapper around Java's `joda-time` for parsing. It has to handle a peculiar edge-case, like so:

```clojure
(defn parse-dt
  [dt-str]
  (try
    (time-format/parse parse-many dt-str)
    (catch org.joda.time.IllegalInstantException e
      (.. (time-format/parse-local parse-many dt-str)
          (plusHours 3)
          (toDateTime)))))
```

`IllegalInstantException` can be thrown because some of my randomly generated times fall on 2017-03-22, which is daylight savings time; Joda refuses to guess how we want to represent certain times of day. (E.G.: 2017-03-22 02:12:00 never actually happened, because we'd have skipped from 1am directly to 3am.)

It'll be interesting to see how other libraries handle this.


<a id="orgaf12486"></a>

# Compiles to JavaScript

I've been thinking about this line so much lately: "compiles to JavaScript". It's become common as hell. Some languages target JavaScript exclusively (PureScript), but the list of things that will generate JS for you is getting bewildering. My own dear Clojure has ClojureScript; nim will go to JS. An astonishing number of languages will let you go to JS.

So on the one hand, this seems good! Node gives JS a systems runtime you can install damn near anyplace, not to mention running your code in browsers.

And on the other hand: I have not been able to decide how excited I am to have to learn Node and the JS ecosystem *on top* of whatever other languages I look at. There's something about trying to write two languages at once that just sounds&#x2026; well. Let's consider two different things one could do:

You could decide to use ClojureScript to write a JS front end for a web server.

You could decide to use ClojureScript to write a script that collects CSVs off a set of remote servers and summarizes them.

In the first example: you're already setting out to the land of JS. You're probably going to have a very nice time. But in the second, JS, Node, is incidental &#x2013; it's like having to reason about generated C code. All you're doing is increasing the incidental complexity of a task, and that's exactly what I'd like to avoid. But who knows &#x2013; maybe it's not actually that complex? We'll see.


# The Languages


## [nim](http://nim-lang.org)

Statically typed and pseudo-imperative, with an emphasis on its hygienic macro system and compiler optimizations. Tastes like somebody couldn't chose between Python and Haskell and just doing it in C, so rolled the three together. Might be way more of a system's language than I really want.

`nim` is on the one hand relatively easy to read, and on the other, has a wide variety of peculiarities. For instance: procedures have an implicit `result` variable, and while `nim` will manage a lot of memory for you, it will also let you get up to your elbows in heap and pointers. I can see how this would excite someone who wanted to take a lot less time writing C; I'm not sure I'm in to it.

The docs would have you think that rather than being Object-Oriented, `nim` embraces *procedural* programming. A Procedure is `nim`'s equivalent of a function. Intriguing.

Gotta be honest: so far, a few hours of research in to this language have made me feel a little squeamish about doing anything with it at all, but I'm gonna give it a go.


### Toolchain

-   nim, the compiler
-   nimble, the package manager
-   nimsuggest, a suggestion backend for IDEs
-   Emacs major mode with
    -   company backend
    -   org-babel support
-   **No. REPL.** Eek.


### Notes:

-   There's a brew installer, but it's a release behind; mostly they seem to target Windows? \*nix installation is pretty manual, and inexplicably doesn't include `nimble`, the package manager. (Later I have found `nim` is, in fact, install-able via brew.)
-   Instructions for installing nim-mode for emacs suggest installing `nimsuggest`, which one clones and performs a `nimble build` on. This installs an entirely different version of the compiler than you just installed in the previous step, but also fails to provide a `nimsuggests` binary anywhere useful (the binary winds up in the root of the git repo. Cool.)
-   An hour after I decided to try and write some Nim I think I have **finally** gotten stuff installed at all?
-   Compiles to highly optimized C, making binaries pretty effing portable.
-   `block` statement introduces a new scope; interesting
-   `nim` "achieves functional programming techniques", which means functions are&#x2026; well not first class, but not second class either. It's weird.
-   Boy they have a hellova macro system. Geeze.
-   There's a note in their "probably out of date" tutorial that just sort of says "oh btw you can compile to JavaScript". Intriguing.
-   Compiling and installing a local binary is "baked in" to the language at a pretty deep level, which is, honestly?, really nice. Especially given the compiles-to-C approach, this actually makes `nim` smell like a scripting language I could get behind.
-   Holy christ: [this documentation index](http://nim-lang.org/docs/theindex.html).
-   Cannot parse datetimes with a colon in the offset
-   No meaningful regex support; provides a PEG implementation. Not at all convinced I want to clamber around with that. Neat :P
-   No support for `GET` params. Really unclear support for `POST` params. All headers have to be written manually.


### Conclusion

Fast as hell. Full of neat ideas, if you're a capable C programmer who wants something a little shorter. Not ready for prime time. Lotsa rough bits in places I care about. Calling it early: nope.


## [Rust](https://www.rust-lang.org/)

This seems friendly as hell.

Also there are nearly three thousand open github issues.

Also it has taken most of *Return of the Jedi* to install. It has in fact taken so long that I started trying to grok F#.

Rust has take then full length of *Return of the Jedi* to get in to a passable state. I probably should have installed via brew. JFC.

We're&#x2026; gonna come back to this if I have time. Holy hell.


## [F#](http://fsharp.org/)

I have to admit &#x2013; and I do not know why this is &#x2013; I've gotten *really* curious about F#. In the materials published by the F# organization, it comes up over and over again as a language for working with data.

Since the first pass &#x2013; which was late at night and not done with the most, uh, *attention* &#x2013; I've found better information on getting going with F# on OSX. Let's try this&#x2026; again.


### Installation

F# wants you to use a baked-in version in either Visual Studio or Xamarin Studio. I want none of this. Instead, we do:

```sh
brew install mono
```

`mono` is an open-source version of the .NET framework, and comes with C# baked in as well. Okay. Fine so far.

From here, we find the [Cross Platform Guide](http://fsharp.org/guides/mac-linux-cross-platform/), which points us to a project management tool called `forge`. So far, so good. We can get it with:

```sh
brew tap samritchie/forge && brew install forge
```

Note: this will install version 0.7, which is current as of four months ago (I **believe** forge is nearing it's 1.0 release). Great. Doing fine there, too.

Next is NuGet, the F# package manager. We add its SSL cert, do a little curling, and thennnnnnn. Well. And then some utility scripting needs to happen.

```sh
sudo mozroots --import --sync
curl -L http://nuget.org/nuget.exe -o nuget.exe
```

So this, also, not too bad. NuGet has to run with `mono`, so let's wrap it:

```sh
#!/bin/bash

NUGGET_EXE=/Users/gastove/opt/nuget.exe

mono "$NUGGET_EXE" "$@"
```

Good. Okay.


### Impressions thus far

This is a **big** ecosystem of different tools, and they work&#x2026; in a wide variety of ways. `forge`, for instance, wants to read (shudder) XML, and can automatically install packages with NuGet &#x2013; but NuGet reads a JSON config file. Ergm. Okay.

Perhaps my biggest challenge thus far is just how *differently* these tools think than the ones I'm used to. For instance, the Mac Cross-Platform docs on fsharp.org casually mention:

> It is quite common to check a copy of NuGet.exe into a project, e.g. in lib/NuGet/NuGet.exe.

Which feels pretty *ohmygodwhut* to this linux developer. Binaries! In! Version! Control! Why!? How!?!?


### Actually figuring out how to write F#

Now we get to what is, for me, one of the weirdest parts so far: I can find almost 0 cohesive text on how to actually *write* F#. There's a whole pile of stuff under the heading "Learn" on fsharp.org, but the execution is bewildering. There's tryfsharp.org, which wants to teach you interactively in a site that requires Microsoft Silverlight, which is [no longer compatible with Chrome > 44](https://support.microsoft.com/en-us/kb/3058254). There's a blog dedicated, at least in theory, to the concept of "F# for C/Java/Python Developers", but it mostly seems like it wants to make the *case* for F#, not actually teach it. You can buy books on F#; I am not sure I want to buy a book just yet. (Also, <span class="underline">Beginning F# 4.0</span> costs &#x2013; wait for it &#x2013; $32 for the ebook? Compare-and-contrast with the PureScript book, which is pay-what-you-want and capped at $20.)<sup><a id="fnr.3" class="footref" href="#fn.3">3</a></sup>

[The F# Cheat Sheet](http://dungpa.github.io/fsharp-cheatsheet/) is pretty useful, but so far [www.tryfsharp.org](http://www.tryfsharp.org) is the most promising. So I guess I will turn on Firefox and install Silverlight? Jesus this is weird.


### An Interlude of Good News

Y'all, F# is a *lovely* language. Compelling as heck. I wanna figure this out. It seems to have data work in its bones.


### A Bewilderment of Tools

So Try F# is good and now I have a taste of the language and I want to write some. In particular, I want to F#'s incredible-seeming "type provider" mechanism, particularly the [Data](http://fsharp.github.io/FSharp.Data/) type providers. They don't come baked in, so I need to install them.

Okay.

First I try `nuget install`. This gets me a directory, saved within whichever directory I called `nuget install` from, into which `FSharp.Data` has been installed (plus another dir for `Zlib`). I can't figure out how to use this anyplace. Neat. Good. Next idea.

I notice that `forge` has created a bunch of `paket` files &#x2013; most interestingly, `paket.dependencies`. A quick googling indicates `paket` is an even-more-different package manager for F#, providing much better management for things like transitive dependencies. This seems good. I add `nuget FSharp.Data` to my `paket.dependencies`, and set about trying to call `paket`. It once again works *real weird* on linux:

```sh
mono .paket/paket.exe install
```

This installs `FSharp.Data`, but not in a way that is usable. I set off to the [Paket documentation](https://fsprojects.github.io/Paket/index.html) and begin learning a few strange things:

1.  I can convert a NuGet project to a paket project with a baked in command.
2.  F# makes the assumption that you'll have one *repository* with many *projects* inside of it. Each project needs to declare it's own deps, via a `paket.references` file. This file will be generated automatically from the NuGet `package.config`.
3.  Or it *would* be generated automatically, if the `forge` template didn't name the config file `App.config`, which `paket` cannot correctly convert. You'll wanna rename that.
4.  Which *also* means you need to remove `App.config` from the `.fsproj` file XML. Otherwise compilation will fail.

Also: the `forge` docs seem to suggest you should do something like `forge --dir src --name ProjectName --template app`. This will make you a reasonable src dir, plus a lot of extra stuff, plus initialized `paket` things. But, it will *not* create your `paket.references` (which I think is still needed), and you'll need to run `paket` with `--force` to get everything working the first time.

Now all you have to do is manually add `FSharp.Data` to your `paket.references` and you can go pass out quietly in a corner and think fond thoughts about leiningen.

Oh, and another thing: every example of using `FSharp.Data` opens with some version of this line:

```fsharp
#r "FSharp.Data"
```

This will immediately explode when you put it in a file. The `#r` form is allowed *only* in interactive F#. For standard F# files (files with the `.fs` extension), what you want is:

```fsharp
open FSharp.Data
```

Whew.

<span class="timestamp-wrapper"><span class="timestamp">&lt;2016-06-27 Mon&gt; </span></span> I have learned of `fsproj` files. These are XML build specs that control how the compiler builds your code together. Being an XML file, it's very difficult to intuit how to operate it. Glee.

*But wait!* There's a tool for this, too: [Projekt](http://fsprojects.github.io/Projekt/). Good. Fine. More tools. (It is at this point, I confess, tempting to try and write yet another tool to tie this whole works together. And also that seems like a Yet Another Standard problem :/)


### First Coding: the CSV cleaner

With all this assembled, what is it like to actually write some F#? Let's rock.

First step: CSV cleaning. A *big* part of F#'s draw for me is the [FSharp.Data](http://fsharp.github.io/FSharp.Data/index.html) package, and getting it going is easy as can be:

```fsharp
open FSharp.Data

let csvPath = "/Users/gastove/Code/language-tour/data-generator/2016-06-16_random_data.csv"

type DemoRecord = CsvProvider<"/Users/gastove/Code/language-tour/data-generator/2016-06-16_random_data.csv", Separators="|", Schema="Date,PhoneNumber">

let data = DemoRecord.Load(csvPath)
let firstRow = data.Rows |> Seq.head
let firstDate = firstRow.Date
let firstPn = firstRow.PhoneNumber
```

The `CsvProvider` seen in action here is a "type provider", and it's doing a *bunch* of heavy lifting under the covers. Specifically, it's reading the first thousand lines of the file and trying to correctly assign each column a type. Some notes about this:

-   It has some pretty odd behaviors with underscores &#x2013; the column named `phone_number` became a an attribute called `Phone_number`. The `Schema` declaration is entirely to adjust this.
-   Half the CSV parsing battle in this file is cleaning up the three different date formats<sup><a id="fnr.4" class="footref" href="#fn.4">4</a></sup> in the Date column. F# correctly identified that column as a date *and correctly parsed each format*. Holy damn.
-   Note that we pass the same string two places. The *intention* here is that you can separate the *analysis* of a CSV from its parsing &#x2013; so the type provider could be constructed with a short data sample and then be used to load N data sources of same schema. This is neat, but also: the type provider's constructor cannot accept a file path passed in an identifier (e.g. `csvPath`) &#x2013; it *has* to receive a string literal and I do not know why.<sup><a id="fnr.5" class="footref" href="#fn.5">5</a></sup>


### <span class="timestamp-wrapper"><span class="timestamp">&lt;2016-06-16 Thu&gt; </span></span> The First Pass

Pro: seems mature!

Con: oh god Microsoft products this is weird as shit.

Now that I've installed `mono` and used it to build and run the F# package manager, I've also run the F# koans. Which go like this:

    gastove@concordance λ ~/Code/open-source/FSharpKoans on fsharp[!]
    $ mono FSharpKoans/bin/Debug/FSharpKoans.exe


    about asserts:
        AssertExpectation failed.



    You have not yet reached enlightenment ...
      Expected: 2
      But was:  "FILL ME IN"


    Please meditate on the following code:
      at NUnit.Framework.Assert.That (System.Object actual, IResolveConstraint expression, System.String message, System.Object[] args) <0x1067cb790 + 0x00122> in <filename unknown>:0
      at NUnit.Framework.Assert.AreEqual (System.Object expected, System.Object actual) <0x1067cb200 + 0x00032> in <filename unknown>:0
      at FSharpKoans.Core.Helpers.AssertEquality[a,b] (FSharpKoans.Core.a x, FSharpKoans.Core.b y) <0x1067cb1a0 + 0x00044> in <filename unknown>:0
      at FSharpKoans.about asserts.AssertExpectation () <0x1067cb160 + 0x0001f> in <filename unknown>:0
      at (wrapper managed-to-native) System.Reflection.MonoMethod:InternalInvoke (System.Reflection.MonoMethod,object,object[],System.Exception&)
      at System.Reflection.MonoMethod.Invoke (System.Object obj, BindingFlags invokeAttr, System.Reflection.Binder binder, System.Object[] parameters, System.Globalization.CultureInfo culture) <0x105a1bcc0 + 0x000a3> in <filename unknown>:0




    Press any key to continue...

Also, frankly, I can't find any other coherent "getting going with this language" guides and I have no interest in buying a book. So that's fine. And enough F# for me. Jesus.

In conclusion: while F# cheerfully tells you it is multi-platform, I can't find a coherent story for how to get it up and ticking on Linux. This might be fine if running a compiled binary was wicked easy &#x2013; but I can't find any evidence of that either. Putting this in my back pocket for if I ever need to develop professionally on Windows.


## [Racket](https://racket-lang.org/)

Ah. Racket. Gah, I have such mixed feels.

Racket wants you to use it for things. It is kind and well thought out. The standard library is ginormous and pretty parts-complete, and for those few things that need an external library, they mostly seem to be available.

It has functions to parse a CSV; it has functions to call a procedure on every line of a CSV. It has support for PCRE. Via a third-party library you get CLDR date parsing. It's mature. The online documentation is **gorgeous**. It has a REPL! And pretty nice Emacs tooling.

And.

Something about it&#x2026; I don't get. The entire notion of a *project*, of how you go from single files to to a well-ordered application, doesn't&#x2026; seem to click. You get the surprising power of [Scribble](https://docs.racket-lang.org/scribble/), the Racket documentation tool. But: Scribble is your only option. There are no doc strings. There's no especially clear way to document an *application*. It supports a bajillion different programming ideas, but the logic of how they should go together doesn't&#x2026; It just doesn't *click*, for me. At least, not yet.

Also true: it can be totally overwhelming in its presentation of information about a thing.

And performance is a little unclear. Nim takes just over three seconds to count the ten million lines of the test csv; racket, straight up, takes almost a minute. Bizarrely, pre-compiling this doesn't seem to have&#x2026; *any effect*. Neat. The deploy story is unclear; distribution is unclear.

I just do not know what to make of this language.


## ClojureScript


### Introduction

I'm a Clojure developer. I want to escape the JVM. The elephant in the room, then, is ClojureScript. What's like Clojure but isn't Java? You get the idea.

I've resisted ClojureScript. Frankly, I'm not perfectly sure *why*. Something about the added complexity of [Compiles to JavaScript](#orgaf12486) has made me squeamish. And, it's not like JS is known for a) it's dazzling type system, or b) it's stunning performance.

And yet! And yet. Let's consider both points for a moment.

-   Types

    So I like being able to annotate my types; I'd like to get an error when they don't line up. One doesn't usually think "JavaScript" when one thinks sophisticated type systems; instead, one thinks Haskell or Scala.

    But here's the thing: types don't really have to enter the runtime, for my purposes. I'd be perfectly content with a gradual or optional type system, *a la* Racket. I love this [talk](https://www.youtube.com/watch?v=JBmIQIZPaHY) between Matthias Felleisen and Gilad Bracha; they argue between themselves that the point of a type system is for the user, primarily for documentation. This idea moves me.

    And: Clojure *has* something like an optional type system now, in its new [clojure.spec](https://clojure.org/about/spec) library. We've gained the ability to indicate and enforce the shape we expect our data to take. So who cares if those types don't enter the JS runtime? I don't think the answer is me.

-   Performance

    There's a **lot** of energy being put in to JavaScript &#x2013; from V8 to the Closure library. It seems perfectly plausible to me that JS performance could be a lot less of a thing than I'd wondered about. Now: I've got no clue what the concurrency model is like. We're gonna have to see how this goes. But, it just doesn't seem like this is a reason not to try it!

    Let's get rolling.


### Getting started

So this is all well and good; what's it like to get going? I've got a great handle on Clojure, a good handle on Java, and almost no handle on the JavaScript ecosystem. How hard could it be?

The answer is: we'll see, but maybe very.

-   Setting up a project

    This part? Easy as can be. Our old friend leiningen has templates for ClojureScript projects, with or without Figwheel. Figwheel does nothing we need for a stand-alone CLI project, so we skip it. There's some minimal tweaking needed in our `project.clj`, but it really is minimal. A very short distance in and I have a tiny app that compiles and runs with node.

    &#x2026;except that I've also found that I should have a build.clj file? Which I don't, and yet, everything is, so far, working. So that's&#x2026; that's unsettling.

-   OK, now what

    Next task: how do I read a file? Surely this'll be easy, right?

-   But wait

    It turns out, connecting figwheel is actually necessary, *for some reason*. I cannot understand why, but when I attempt to connect CIDER to a project without figwheel connected, it explodes. Grand.

    And: I cannot seem to get it to work, for love or money. I've been fighting it for two hours.

    *Some Time Passes*

    Got it. Past Ross was a clever lad and hard-coded figwheel as the REPL type in his Clojure emacs configs. Goddamnit. So. Much.

    Finally switched to a Node repl, everything is Flying along.

-   Really actually getting going

    Here we begin to see the true weird part of ClojureScript for me: the runtime.

    I've written a bunch of Java and lots of both Scala and Clojure. For those languages, Java &#x2013; the host language &#x2013; provides a base frame of reference for&#x2026; mostly everything. Scala is probably the most divergent, but host interop is still big; in Clojure we go to Java all the time (e.g. `clojure.java.io`). I've done this before with F#, where .NET provides a great deal of core functionality.

    In ClojureScript, we're going instead to Node, and it is&#x2026; different. .NET has a lot of ideas in common with Java &#x2013; or at least, both ideas are using very similar core concepts. Want to read a file? Here's a class that'll hand you one line at a time. But Node is deeply and profoundly async and event-driven. Vis:

    ```clojure
    (defn count-file [path]
      (let [status (atom 0)
            input (.createReadStream fs path)
            rl (open-line-reader input)]
        (.on rl "line" #(swap! status inc))
        (.on rl "close" #(println @status))))
    ```

    We open a file interface, and then take action every time we get a `line` event (which is of course identified by a string name b/c JavaScript).

    Sooooooooo.

    This presents two challenges:

    1.  The tooling present for my kind of work is not rich in CLJS land.
    2.  Node presents some metaphors built for very different work than mine.

    Can I write wrappers that get the Stuff done? That's the question.

-   Reading lines

    For our first trick: reading lines. You know what a great abstraction I love is? Clojure's `core.async`. Reading lines in to a channel is magnificently easy.

-   Parsing Lines

    Parsing turns out to have an advantage: I can re-use a good deal of my code from my reference implementation.

-   Result

    So. I've gotten the CSV parsing part of this done; it works. It certainly&#x2026; yeah. We can say that for sure.

    But, there are two things:

    1.  Getting this set up so stack traces didn't murder my eyes was *awful*.
    2.  It is impossibly slow.

    This is not just slow. This is ten or maybe fifteen times slower than the Clojure reference implementation. This&#x2026; no. This wont do. Now, a true fact: I'm not a Node dev. Maybe I've messed this right up? I dunno where in here anything would block, but let's be real &#x2013; making Node go fast is not my core skill set. I could easily have just gotten it wrong.

    &#x2026;but the code smells right-ish. It is, at least, reasonably clear to me. It was awful to debug, but it was reasonably pleasant to knock together at first.

    But I am calling it here. ClojureScript will be excellent for web-work, and probably for hitting REST APIs, but for data scrubbing, I'ma, uh, stick with something else.


## Julia


## Haskell

C'mon. I gotta.

## Footnotes

<sup><a id="fn.1" class="footnum" href="#fnr.1">1</a></sup> In retrospect: wat.

<sup><a id="fn.2" class="footnum" href="#fnr.2">2</a></sup> Slack has created a JS interface to Apache Spark. When people say, "Node.js has incredibly fast file operations," what they really mean is, "Node.js provides a clean, easy-to-reason about interface to libuv." libuv is in C.

<sup><a id="fn.3" class="footnum" href="#fnr.3">3</a></sup> I have since found that the linked copy from fsharp.org is a Google books editions *that is just literal scans of the paper edition*. Or: you could buy a Real Ebook from [Apress](http://www.apress.com/9781484213759?gtmf=s) for $19.19. (Hint: do that second one.)

<sup><a id="fn.4" class="footnum" href="#fnr.4">4</a></sup> ISO-8061 date time without timezone, ISO-8061 date, and RFC-822

<sup><a id="fn.5" class="footnum" href="#fnr.5">5</a></sup> Ah, I have learned why. Even though `let` introduces an immutable identifier, it is *not* considered constant. However, this syntax can be used to tell the compiler, "It's OK, use the literal value of this identifier at compile time":

```fsharp
[<Literal>]
let x = "hi"
```