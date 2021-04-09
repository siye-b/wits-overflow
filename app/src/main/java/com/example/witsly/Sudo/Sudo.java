package com.example.witsly.Sudo;

public class Sudo {


    Developers:
    OverOps tells
    you when new
    code breaks
    in production –
    Learn more


    As Java
    developers working
    with a
    language that’
    s both
    mature yet
    highly evolving, we’
    re faced
    with a
    constant dilemma
    whenever we
    write new code –
    go with
    the hot new
    technology that
    everyone is
    talking about, or
    stick with
    a tried-and-true library?

    Since a
    very large
    part of
    Java applications
    are commercial
    in nature, it
    can sometimes
    be hard
    to separate
    the buzz
    around a new
    framework with
    the number
    of projects
    actually putting
    it to
    use.This is
    important,
    as the
    community of
    users and
    contributors around
    a framework
    is one
    of the
    strongest factors
    in determining
    its continuous
    success and
    development.

            We decided
    to use
    a data
    based approach
    to get
    more insight
    into this,
    by analyzing
    which Java
    projects developers
    are actually
    using on
    the world’
    s largest
    open repository for
    Java projects –
    GitHub.

            In our
    previous post
    we presented
    the main
    results of
    our GitHub
    research project
    and the
    top 100 libraries for JavaScript,
    Ruby and
    Java.Now let’
    s dive
    into the
    data,
    analyzing Java
    in particular.

    The Approach
    To generate
    our dataset
    we queried 10,000
    Java projects, with
    a bias
    towards the
    ones most
    favorited by
    the community, as
    a strong
    qualifying indicator
    towards their
    relative importance.
    We used
    the pom.xml,
    which is
    used by
    the vast
    majority of
    Java projects
    on GH, to
    define dependencies.
    We then
    analyzed and
    grouped those
    into categories.
    The results
    were really
    interesting.

            The Results
    The full
    list –Top 100 libraries for JavaScript,
    Ruby and
    Java
01
    Logging.The most
    popular Java
    library is
    slf4j –
    the logging
    facade framework, with 3,068
    entries.It seems
    that Java
    GH developers
    have fully
    embraced a
    decoupled approach
    towards their
    logging engine, and
    have standardized
    on slf4j
    to do
    so.
            Since slf4j
    isn’
    t a
    logging engine
    by itself, it’
    s also
    useful to
    see the
    top logging
    engines being
    used.It looks
    like the “winner”
    here is
    log4j – 891
    projects are
    using it.
    Next in
    line is
    Logback,with 340
    projects.While very
    respectable,this
    number still
    represents less
    than half
    of the
    projects using
    log4j.sfl4j’
    s simple
    logging implementation
    comes in
    third at 174
    projects.

            The most
    popular Java
    library today
    is slf4j –
    used by 30.7%
    of the 10,000

    projects(Tweet this)

    Spring.While Spring
    may be
    perceived by
    some as
    a more
    mature and
    less “hip”framework,
    it still
    sees tremendous
    usage,placing 15
    libraries in
    the top 100.
    Since Spring
    is an
    umbrella framework, it’
    s interesting
    to see
    which of
    its components
    are being
    used the
    most.Spring-
    test is
    the most
    used part
    of the

    framework(after the core library) with 376 entries.It’
    s followed
    by web-mvc for
    designing robust
    web applications
    with 277
    entries.After web
    functionality,
    we see
    web-
    orm with 218 entries,
    highlighting Spring’
    s key
    use case for
    building a
    DB backed
    Java web
    application.
            TDD.Right there
    with Spring
    at the
    top is
    JUnit with 3,068
    entries.This really
    shows the
    profound effect
    that Test
    Driven Development
    has had
    on the
    Java landscape.
    It seems
    that if you’
    re a
    Java developer
    posting your
    code,
    unit tests
    today are
    an absolute
    requirement.It’
    s also
    worthwhile noting
    that while
    JUnit is
    not alone
    in this

    space(TestNG, the 2 nd most popular testing framework, has 331 entries) it is by far the most dominant.
            [
    adrotate group =”11″]
    Mockito,
    a popular
    framework for
    mock based
    testing,
    has also
    gained wide
    appeal with 413 entries.EasyMock,
    another mocking
    framework,comes 2
    nd in this
    category with 231
    project entries.

    Google’
    s Guava
    framework is
    becoming mainstream – 4.8%of 10,000
    Java GitHub
    projects are

    using it(Tweet this)

    Apache Commons.
    Having looked
    at Spring, it’
    s important
    we don’
    t neglect
    Apache Commons, one
    of the
    most fundamental
    set of
    libraries within
    the language.Commons-
    io and
    Commons-
    lang are
    right there
    in the
    top 10 with 519 and 504
    entries respectively, showing
    their strong
    prevalence.
            As a
    whole Apache
    Commons have 13
    libraries in
    the top 100.Google’
    s Guava
    framework,
    which itself
    provides language

    utils(some similar to those found in Commons) is also doing very well with 483 entries,
    marking it
    as another
    key Java
    building block.
            04(1)
    Sql &
    NoSql.With NoSql
    and Big
    data being
    all the
    buzz these
    last couple

    of years(some for good reasons),it’
    s worthwhile
    looking at
    the actual
    usage numbers for
    both relational
    and NoSql
    technologies.The most
    popular Sql
    DB out
    there is
    MySql with 225
    entries.Hibernate ORM, while
    not a
    DB in
    itself,
    is also
    fairly popular
    with 181
    entries.This is
    one area
    that we
    need to
    keep in
    mind that
    as GH
    is an
    open source
    repository,
    we might
    see a
    somewhat stronger
    bias towards
    commercial DBs
    such as
    Oracle’
    s in
    a closed
    source dataset.

    Justifying the
    buzz:
    Hadoop is
    more popular
    in Java
    GitHub projects
    than Postgre

    SQL(Tweet this)

    Hadoop is
    also doing
    very well
    with 168 entries,
    showing that
    the buzz
    is justified
    when looking
    at its
    actual usage
    data.To put
    in perspective, it
    has more
    entries than

    Postgre SQL(with 121 entries),one of the most mature relational open source DBs out there.
    ElasticSearch,
    another Big
    data technology, is
    also on
    the board
    with 110
    project entries.It’
    s surprising
    to note
    that sqlite, which
    has 1,085
    entries in
    Ruby,isn’
    t in
    the Java
    top 100.
    Android.For mobile
    developers on
    GH we
    see 228
    project entries
    consuming Android
    via Maven.While this
    can signify
    that not
    a lot
    of mobile
    projects are
    placed on
    GH,it’
    s still
    a strong
    indicator that
    Java remains
    a very
    strong server
    side language.
    Surprised by
    some of
    the results?
    We know
    we were
    with some
    of them.
    Take a
    look at
    the full
    list of
    the top 100
    Java libraries
    on GitHub
    below,
    and let
    us know
    what you
    think in
    the comments
    section.We’
    d love
    to hear
    your thoughts
    and questions.

    main2(1)

    We Analyzed 30,000
    GitHub Projects –
    Here Are
    The Top 100
    Libraries in
    Java,
    JS and
    Ruby –
    read more


    Ophir Primat
    As VP
    Marketing,
    Ophir is
    in charge
    of driving
    OverOps' marketing strategies, demand generation, brand recognition and communications. Previously, Ophir was a financial journalist and editor-in-chief at Forbes Magazine. Considers dessert a full meal.

    developers
            Github
    Java
    Further Reading

    Featured Post
    Achieving Observability:
    How to
    Address the
    Unknown Unknowns
    in Your
    Application
    Get it
    Now

    Next Article

    We Analyzed 30,000
    GitHub Projects -
    Here Are
    The Top 100
    Libraries in
    Java,
    JS and
    Ruby
6
    min read
    Move Fast.
    Fix Faster.
    Prevent Rapid
    Code Changes
    From Impacting
    Customers.Identify and
    Resolve Your
    Most Critical
    Issues in
    Minutes.
            Learn More

    Developers:
    OverOps tells
    you when new
    code breaks
    in production –
    Learn more


    As Java
    developers working
    with a
    language that’
    s both
    mature yet
    highly evolving, we’
    re faced
    with a
    constant dilemma
    whenever we
    write new code –
    go with
    the hot new
    technology that
    everyone is
    talking about, or
    stick with
    a tried-and-true library?

    Since a
    very large
    part of
    Java applications
    are commercial
    in nature, it
    can sometimes
    be hard
    to separate
    the buzz
    around a new
    framework with
    the number
    of projects
    actually putting
    it to
    use.This is
    important,
    as the
    community of
    users and
    contributors around
    a framework
    is one
    of the
    strongest factors
    in determining
    its continuous
    success and
    development.

            We decided
    to use
    a data
    based approach
    to get
    more insight
    into this,
    by analyzing
    which Java
    projects developers
    are actually
    using on
    the world’
    s largest
    open repository for
    Java projects –
    GitHub.

            In our
    previous post
    we presented
    the main
    results of
    our GitHub
    research project
    and the
    top 100 libraries for JavaScript,
    Ruby and
    Java.Now let’
    s dive
    into the
    data,
    analyzing Java
    in particular.

    The Approach
    To generate
    our dataset
    we queried 10,000
    Java projects, with
    a bias
    towards the
    ones most
    favorited by
    the community, as
    a strong
    qualifying indicator
    towards their
    relative importance.
    We used
    the pom.xml,
    which is
    used by
    the vast
    majority of
    Java projects
    on GH, to
    define dependencies.
    We then
    analyzed and
    grouped those
    into categories.
    The results
    were really
    interesting.

            The Results
    The full
    list –Top 100 libraries for JavaScript,
    Ruby and
    Java
01
    Logging.The most
    popular Java
    library is
    slf4j –
    the logging
    facade framework, with 3,068
    entries.It seems
    that Java
    GH developers
    have fully
    embraced a
    decoupled approach
    towards their
    logging engine, and
    have standardized
    on slf4j
    to do
    so.
            Since slf4j
    isn’
    t a
    logging engine
    by itself, it’
    s also
    useful to
    see the
    top logging
    engines being
    used.It looks
    like the “winner”
    here is
    log4j – 891
    projects are
    using it.
    Next in
    line is
    Logback,with 340
    projects.While very
    respectable,this
    number still
    represents less
    than half
    of the
    projects using
    log4j.sfl4j’
    s simple
    logging implementation
    comes in
    third at 174
    projects.

            The most
    popular Java
    library today
    is slf4j –
    used by 30.7%
    of the 10,000

    projects(Tweet this)

    Spring.While Spring
    may be
    perceived by
    some as
    a more
    mature and
    less “hip”framework,
    it still
    sees tremendous
    usage,placing 15
    libraries in
    the top 100.
    Since Spring
    is an
    umbrella framework, it’
    s interesting
    to see
    which of
    its components
    are being
    used the
    most.Spring-
    test is
    the most
    used part
    of the

    framework(after the core library) with 376 entries.It’
    s followed
    by web-mvc for
    designing robust
    web applications
    with 277
    entries.After web
    functionality,
    we see
    web-
    orm with 218 entries,
    highlighting Spring’
    s key
    use case for
    building a
    DB backed
    Java web
    application.
            TDD.Right there
    with Spring
    at the
    top is
    JUnit with 3,068
    entries.This really
    shows the
    profound effect
    that Test
    Driven Development
    has had
    on the
    Java landscape.
    It seems
    that if you’
    re a
    Java developer
    posting your
    code,
    unit tests
    today are
    an absolute
    requirement.It’
    s also
    worthwhile noting
    that while
    JUnit is
    not alone
    in this

    space(TestNG, the 2 nd most popular testing framework, has 331 entries) it is by far the most dominant.
            [
    adrotate group =”11″]
    Mockito,
    a popular
    framework for
    mock based
    testing,
    has also
    gained wide
    appeal with 413 entries.EasyMock,
    another mocking
    framework,comes 2
    nd in this
    category with 231
    project entries.

    Google’
    s Guava
    framework is
    becoming mainstream – 4.8%of 10,000
    Java GitHub
    projects are

    using it(Tweet this)

    Apache Commons.
    Having looked
    at Spring, it’
    s important
    we don’
    t neglect
    Apache Commons, one
    of the
    most fundamental
    set of
    libraries within
    the language.Commons-
    io and
    Commons-
    lang are
    right there
    in the
    top 10 with 519 and 504
    entries respectively, showing
    their strong
    prevalence.
            As a
    whole Apache
    Commons have 13
    libraries in
    the top 100.Google’
    s Guava
    framework,
    which itself
    provides language

    utils(some similar to those found in Commons) is also doing very well with 483 entries,
    marking it
    as another
    key Java
    building block.
            04(1)
    Sql &
    NoSql.With NoSql
    and Big
    data being
    all the
    buzz these
    last couple

    of years(some for good reasons),it’
    s worthwhile
    looking at
    the actual
    usage numbers for
    both relational
    and NoSql
    technologies.The most
    popular Sql
    DB out
    there is
    MySql with 225
    entries.Hibernate ORM, while
    not a
    DB in
    itself,
    is also
    fairly popular
    with 181
    entries.This is
    one area
    that we
    need to
    keep in
    mind that
    as GH
    is an
    open source
    repository,
    we might
    see a
    somewhat stronger
    bias towards
    commercial DBs
    such as
    Oracle’
    s in
    a closed
    source dataset.

    Justifying the
    buzz:
    Hadoop is
    more popular
    in Java
    GitHub projects
    than Postgre

    SQL(Tweet this)

    Hadoop is
    also doing
    very well
    with 168 entries,
    showing that
    the buzz
    is justified
    when looking
    at its
    actual usage
    data.To put
    in perspective, it
    has more
    entries than

    Postgre SQL(with 121 entries),one of the most mature relational open source DBs out there.
    ElasticSearch,
    another Big
    data technology, is
    also on
    the board
    with 110
    project entries.It’
    s surprising
    to note
    that sqlite, which
    has 1,085
    entries in
    Ruby,isn’
    t in
    the Java
    top 100.
    Android.For mobile
    developers on
    GH we
    see 228
    project entries
    consuming Android
    via Maven.While this
    can signify
    that not
    a lot
    of mobile
    projects are
    placed on
    GH,it’
    s still
    a strong
    indicator that
    Java remains
    a very
    strong server
    side language.
    Surprised by
    some of
    the results?
    We know
    we were
    with some
    of them.
    Take a
    look at
    the full
    list of
    the top 100
    Java libraries
    on GitHub
    below,
    and let
    us know
    what you
    think in
    the comments
    section.We’
    d love
    to hear
    your thoughts
    and questions.

    main2(1)

    We Analyzed 30,000
    GitHub Projects –
    Here Are
    The Top 100
    Libraries in
    Java,
    JS and
    Ruby –
    read more


    Ophir Primat
    As VP
    Marketing,
    Ophir is
    in charge
    of driving
    OverOps' marketing strategies, demand generation, brand recognition and communications. Previously, Ophir was a financial journalist and editor-in-chief at Forbes Magazine. Considers dessert a full meal.

    developers
            Github
    Java
    Further Reading

    Featured Post
    Achieving Observability:
    How to
    Address the
    Unknown Unknowns
    in Your
    Application
    Get it
    Now

    Next Article

    We Analyzed 30,000
    GitHub Projects -
    Here Are
    The Top 100
    Libraries in
    Java,
    JS and
    Ruby
6
    min read
    Move Fast.
    Fix Faster.
    Prevent Rapid
    Code Changes
    From Impacting
    Customers.Identify and
    Resolve Your
    Most Critical
    Issues in
    Minutes.
            Learn More

    Developers:
    OverOps tells
    you when new
    code breaks
    in production –
    Learn more


    As Java
    developers working
    with a
    language that’
    s both
    mature yet
    highly evolving, we’
    re faced
    with a
    constant dilemma
    whenever we
    write new code –
    go with
    the hot new
    technology that
    everyone is
    talking about, or
    stick with
    a tried-and-true library?

    Since a
    very large
    part of
    Java applications
    are commercial
    in nature, it
    can sometimes
    be hard
    to separate
    the buzz
    around a new
    framework with
    the number
    of projects
    actually putting
    it to
    use.This is
    important,
    as the
    community of
    users and
    contributors around
    a framework
    is one
    of the
    strongest factors
    in determining
    its continuous
    success and
    development.

            We decided
    to use
    a data
    based approach
    to get
    more insight
    into this,
    by analyzing
    which Java
    projects developers
    are actually
    using on
    the world’
    s largest
    open repository for
    Java projects –
    GitHub.

            In our
    previous post
    we presented
    the main
    results of
    our GitHub
    research project
    and the
    top 100 libraries for JavaScript,
    Ruby and
    Java.Now let’
    s dive
    into the
    data,
    analyzing Java
    in particular.

    The Approach
    To generate
    our dataset
    we queried 10,000
    Java projects, with
    a bias
    towards the
    ones most
    favorited by
    the community, as
    a strong
    qualifying indicator
    towards their
    relative importance.
    We used
    the pom.xml,
    which is
    used by
    the vast
    majority of
    Java projects
    on GH, to
    define dependencies.
    We then
    analyzed and
    grouped those
    into categories.
    The results
    were really
    interesting.

            The Results
    The full
    list –Top 100 libraries for JavaScript,
    Ruby and
    Java
01
    Logging.The most
    popular Java
    library is
    slf4j –
    the logging
    facade framework, with 3,068
    entries.It seems
    that Java
    GH developers
    have fully
    embraced a
    decoupled approach
    towards their
    logging engine, and
    have standardized
    on slf4j
    to do
    so.
            Since slf4j
    isn’
    t a
    logging engine
    by itself, it’
    s also
    useful to
    see the
    top logging
    engines being
    used.It looks
    like the “winner”
    here is
    log4j – 891
    projects are
    using it.
    Next in
    line is
    Logback,with 340
    projects.While very
    respectable,this
    number still
    represents less
    than half
    of the
    projects using
    log4j.sfl4j’
    s simple
    logging implementation
    comes in
    third at 174
    projects.

            The most
    popular Java
    library today
    is slf4j –
    used by 30.7%
    of the 10,000

    projects(Tweet this)

    Spring.While Spring
    may be
    perceived by
    some as
    a more
    mature and
    less “hip”framework,
    it still
    sees tremendous
    usage,placing 15
    libraries in
    the top 100.
    Since Spring
    is an
    umbrella framework, it’
    s interesting
    to see
    which of
    its components
    are being
    used the
    most.Spring-
    test is
    the most
    used part
    of the

    framework(after the core library) with 376 entries.It’
    s followed
    by web-mvc for
    designing robust
    web applications
    with 277
    entries.After web
    functionality,
    we see
    web-
    orm with 218 entries,
    highlighting Spring’
    s key
    use case for
    building a
    DB backed
    Java web
    application.
            TDD.Right there
    with Spring
    at the
    top is
    JUnit with 3,068
    entries.This really
    shows the
    profound effect
    that Test
    Driven Development
    has had
    on the
    Java landscape.
    It seems
    that if you’
    re a
    Java developer
    posting your
    code,
    unit tests
    today are
    an absolute
    requirement.It’
    s also
    worthwhile noting
    that while
    JUnit is
    not alone
    in this

    space(TestNG, the 2 nd most popular testing framework, has 331 entries) it is by far the most dominant.
            [
    adrotate group =”11″]
    Mockito,
    a popular
    framework for
    mock based
    testing,
    has also
    gained wide
    appeal with 413 entries.EasyMock,
    another mocking
    framework,comes 2
    nd in this
    category with 231
    project entries.

    Google’
    s Guava
    framework is
    becoming mainstream – 4.8%of 10,000
    Java GitHub
    projects are

    using it(Tweet this)

    Apache Commons.
    Having looked
    at Spring, it’
    s important
    we don’
    t neglect
    Apache Commons, one
    of the
    most fundamental
    set of
    libraries within
    the language.Commons-
    io and
    Commons-
    lang are
    right there
    in the
    top 10 with 519 and 504
    entries respectively, showing
    their strong
    prevalence.
            As a
    whole Apache
    Commons have 13
    libraries in
    the top 100.Google’
    s Guava
    framework,
    which itself
    provides language

    utils(some similar to those found in Commons) is also doing very well with 483 entries,
    marking it
    as another
    key Java
    building block.
            04(1)
    Sql &
    NoSql.With NoSql
    and Big
    data being
    all the
    buzz these
    last couple

    of years(some for good reasons),it’
    s worthwhile
    looking at
    the actual
    usage numbers for
    both relational
    and NoSql
    technologies.The most
    popular Sql
    DB out
    there is
    MySql with 225
    entries.Hibernate ORM, while
    not a
    DB in
    itself,
    is also
    fairly popular
    with 181
    entries.This is
    one area
    that we
    need to
    keep in
    mind that
    as GH
    is an
    open source
    repository,
    we might
    see a
    somewhat stronger
    bias towards
    commercial DBs
    such as
    Oracle’
    s in
    a closed
    source dataset.

    Justifying the
    buzz:
    Hadoop is
    more popular
    in Java
    GitHub projects
    than Postgre

    SQL(Tweet this)

    Hadoop is
    also doing
    very well
    with 168 entries,
    showing that
    the buzz
    is justified
    when looking
    at its
    actual usage
    data.To put
    in perspective, it
    has more
    entries than

    Postgre SQL(with 121 entries),one of the most mature relational open source DBs out there.
    ElasticSearch,
    another Big
    data technology, is
    also on
    the board
    with 110
    project entries.It’
    s surprising
    to note
    that sqlite, which
    has 1,085
    entries in
    Ruby,isn’
    t in
    the Java
    top 100.
    Android.For mobile
    developers on
    GH we
    see 228
    project entries
    consuming Android
    via Maven.While this
    can signify
    that not
    a lot
    of mobile
    projects are
    placed on
    GH,it’
    s still
    a strong
    indicator that
    Java remains
    a very
    strong server
    side language.
    Surprised by
    some of
    the results?
    We know
    we were
    with some
    of them.
    Take a
    look at
    the full
    list of
    the top 100
    Java libraries
    on GitHub
    below,
    and let
    us know
    what you
    think in
    the comments
    section.We’
    d love
    to hear
    your thoughts
    and questions.

    main2(1)

    We Analyzed 30,000
    GitHub Projects –
    Here Are
    The Top 100
    Libraries in
    Java,
    JS and
    Ruby –
    read more


    Ophir Primat
    As VP
    Marketing,
    Ophir is
    in charge
    of driving
    OverOps' marketing strategies, demand generation, brand recognition and communications. Previously, Ophir was a financial journalist and editor-in-chief at Forbes Magazine. Considers dessert a full meal.

    developers
            Github
    Java
    Further Reading

    Featured Post
    Achieving Observability:
    How to
    Address the
    Unknown Unknowns
    in Your
    Application
    Get it
    Now

    Next Article

    We Analyzed 30,000
    GitHub Projects -
    Here Are
    The Top 100
    Libraries in
    Java,
    JS and
    Ruby
6
    min read
    Move Fast.
    Fix Faster.
    Prevent Rapid
    Code Changes
    From Impacting
    Customers.Identify and
    Resolve Your
    Most Critical
    Issues in
    Minutes.
            Learn More

    Developers:
    OverOps tells
    you when new
    code breaks
    in production –
    Learn more


    As Java
    developers working
    with a
    language that’
    s both
    mature yet
    highly evolving, we’
    re faced
    with a
    constant dilemma
    whenever we
    write new code –
    go with
    the hot new
    technology that
    everyone is
    talking about, or
    stick with
    a tried-and-true library?

    Since a
    very large
    part of
    Java applications
    are commercial
    in nature, it
    can sometimes
    be hard
    to separate
    the buzz
    around a new
    framework with
    the number
    of projects
    actually putting
    it to
    use.This is
    important,
    as the
    community of
    users and
    contributors around
    a framework
    is one
    of the
    strongest factors
    in determining
    its continuous
    success and
    development.

            We decided
    to use
    a data
    based approach
    to get
    more insight
    into this,
    by analyzing
    which Java
    projects developers
    are actually
    using on
    the world’
    s largest
    open repository for
    Java projects –
    GitHub.

            In our
    previous post
    we presented
    the main
    results of
    our GitHub
    research project
    and the
    top 100 libraries for JavaScript,
    Ruby and
    Java.Now let’
    s dive
    into the
    data,
    analyzing Java
    in particular.

    The Approach
    To generate
    our dataset
    we queried 10,000
    Java projects, with
    a bias
    towards the
    ones most
    favorited by
    the community, as
    a strong
    qualifying indicator
    towards their
    relative importance.
    We used
    the pom.xml,
    which is
    used by
    the vast
    majority of
    Java projects
    on GH, to
    define dependencies.
    We then
    analyzed and
    grouped those
    into categories.
    The results
    were really
    interesting.

            The Results
    The full
    list –Top 100 libraries for JavaScript,
    Ruby and
    Java
01
    Logging.The most
    popular Java
    library is
    slf4j –
    the logging
    facade framework, with 3,068
    entries.It seems
    that Java
    GH developers
    have fully
    embraced a
    decoupled approach
    towards their
    logging engine, and
    have standardized
    on slf4j
    to do
    so.
            Since slf4j
    isn’
    t a
    logging engine
    by itself, it’
    s also
    useful to
    see the
    top logging
    engines being
    used.It looks
    like the “winner”
    here is
    log4j – 891
    projects are
    using it.
    Next in
    line is
    Logback,with 340
    projects.While very
    respectable,this
    number still
    represents less
    than half
    of the
    projects using
    log4j.sfl4j’
    s simple
    logging implementation
    comes in
    third at 174
    projects.

            The most
    popular Java
    library today
    is slf4j –
    used by 30.7%
    of the 10,000

    projects(Tweet this)

    Spring.While Spring
    may be
    perceived by
    some as
    a more
    mature and
    less “hip”framework,
    it still
    sees tremendous
    usage,placing 15
    libraries in
    the top 100.
    Since Spring
    is an
    umbrella framework, it’
    s interesting
    to see
    which of
    its components
    are being
    used the
    most.Spring-
    test is
    the most
    used part
    of the

    framework(after the core library) with 376 entries.It’
    s followed
    by web-mvc for
    designing robust
    web applications
    with 277
    entries.After web
    functionality,
    we see
    web-
    orm with 218 entries,
    highlighting Spring’
    s key
    use case for
    building a
    DB backed
    Java web
    application.
            TDD.Right there
    with Spring
    at the
    top is
    JUnit with 3,068
    entries.This really
    shows the
    profound effect
    that Test
    Driven Development
    has had
    on the
    Java landscape.
    It seems
    that if you’
    re a
    Java developer
    posting your
    code,
    unit tests
    today are
    an absolute
    requirement.It’
    s also
    worthwhile noting
    that while
    JUnit is
    not alone
    in this

    space(TestNG, the 2 nd most popular testing framework, has 331 entries) it is by far the most dominant.
            [
    adrotate group =”11″]
    Mockito,
    a popular
    framework for
    mock based
    testing,
    has also
    gained wide
    appeal with 413 entries.EasyMock,
    another mocking
    framework,comes 2
    nd in this
    category with 231
    project entries.

    Google’
    s Guava
    framework is
    becoming mainstream – 4.8%of 10,000
    Java GitHub
    projects are

    using it(Tweet this)

    Apache Commons.
    Having looked
    at Spring, it’
    s important
    we don’
    t neglect
    Apache Commons, one
    of the
    most fundamental
    set of
    libraries within
    the language.Commons-
    io and
    Commons-
    lang are
    right there
    in the
    top 10 with 519 and 504
    entries respectively, showing
    their strong
    prevalence.
            As a
    whole Apache
    Commons have 13
    libraries in
    the top 100.Google’
    s Guava
    framework,
    which itself
    provides language

    utils(some similar to those found in Commons) is also doing very well with 483 entries,
    marking it
    as another
    key Java
    building block.
            04(1)
    Sql &
    NoSql.With NoSql
    and Big
    data being
    all the
    buzz these
    last couple

    of years(some for good reasons),it’
    s worthwhile
    looking at
    the actual
    usage numbers for
    both relational
    and NoSql
    technologies.The most
    popular Sql
    DB out
    there is
    MySql with 225
    entries.Hibernate ORM, while
    not a
    DB in
    itself,
    is also
    fairly popular
    with 181
    entries.This is
    one area
    that we
    need to
    keep in
    mind that
    as GH
    is an
    open source
    repository,
    we might
    see a
    somewhat stronger
    bias towards
    commercial DBs
    such as
    Oracle’
    s in
    a closed
    source dataset.

    Justifying the
    buzz:
    Hadoop is
    more popular
    in Java
    GitHub projects
    than Postgre

    SQL(Tweet this)

    Hadoop is
    also doing
    very well
    with 168 entries,
    showing that
    the buzz
    is justified
    when looking
    at its
    actual usage
    data.To put
    in perspective, it
    has more
    entries than

    Postgre SQL(with 121 entries),one of the most mature relational open source DBs out there.
    ElasticSearch,
    another Big
    data technology, is
    also on
    the board
    with 110
    project entries.It’
    s surprising
    to note
    that sqlite, which
    has 1,085
    entries in
    Ruby,isn’
    t in
    the Java
    top 100.
    Android.For mobile
    developers on
    GH we
    see 228
    project entries
    consuming Android
    via Maven.While this
    can signify
    that not
    a lot
    of mobile
    projects are
    placed on
    GH,it’
    s still
    a strong
    indicator that
    Java remains
    a very
    strong server
    side language.
    Surprised by
    some of
    the results?
    We know
    we were
    with some
    of them.
    Take a
    look at
    the full
    list of
    the top 100
    Java libraries
    on GitHub
    below,
    and let
    us know
    what you
    think in
    the comments
    section.We’
    d love
    to hear
    your thoughts
    and questions.

    main2(1)

    We Analyzed 30,000
    GitHub Projects –
    Here Are
    The Top 100
    Libraries in
    Java,
    JS and
    Ruby –
    read more


    Ophir Primat
    As VP
    Marketing,
    Ophir is
    in charge
    of driving
    OverOps' marketing strategies, demand generation, brand recognition and communications. Previously, Ophir was a financial journalist and editor-in-chief at Forbes Magazine. Considers dessert a full meal.

    developers
            Github
    Java
    Further Reading

    Featured Post
    Achieving Observability:
    How to
    Address the
    Unknown Unknowns
    in Your
    Application
    Get it
    Now

    Next Article

    We Analyzed 30,000
    GitHub Projects -
    Here Are
    The Top 100
    Libraries in
    Java,
    JS and
    Ruby
6
    min read
    Move Fast.
    Fix Faster.
    Prevent Rapid
    Code Changes
    From Impacting
    Customers.Identify and
    Resolve Your
    Most Critical
    Issues in
    Minutes.
            Learn More

    Developers:
    OverOps tells
    you when new
    code breaks
    in production –
    Learn more


    As Java
    developers working
    with a
    language that’
    s both
    mature yet
    highly evolving, we’
    re faced
    with a
    constant dilemma
    whenever we
    write new code –
    go with
    the hot new
    technology that
    everyone is
    talking about, or
    stick with
    a tried-and-true library?

    Since a
    very large
    part of
    Java applications
    are commercial
    in nature, it
    can sometimes
    be hard
    to separate
    the buzz
    around a new
    framework with
    the number
    of projects
    actually putting
    it to
    use.This is
    important,
    as the
    community of
    users and
    contributors around
    a framework
    is one
    of the
    strongest factors
    in determining
    its continuous
    success and
    development.

            We decided
    to use
    a data
    based approach
    to get
    more insight
    into this,
    by analyzing
    which Java
    projects developers
    are actually
    using on
    the world’
    s largest
    open repository for
    Java projects –
    GitHub.

            In our
    previous post
    we presented
    the main
    results of
    our GitHub
    research project
    and the
    top 100 libraries for JavaScript,
    Ruby and
    Java.Now let’
    s dive
    into the
    data,
    analyzing Java
    in particular.

    The Approach
    To generate
    our dataset
    we queried 10,000
    Java projects, with
    a bias
    towards the
    ones most
    favorited by
    the community, as
    a strong
    qualifying indicator
    towards their
    relative importance.
    We used
    the pom.xml,
    which is
    used by
    the vast
    majority of
    Java projects
    on GH, to
    define dependencies.
    We then
    analyzed and
    grouped those
    into categories.
    The results
    were really
    interesting.

            The Results
    The full
    list –Top 100 libraries for JavaScript,
    Ruby and
    Java
01
    Logging.The most
    popular Java
    library is
    slf4j –
    the logging
    facade framework, with 3,068
    entries.It seems
    that Java
    GH developers
    have fully
    embraced a
    decoupled approach
    towards their
    logging engine, and
    have standardized
    on slf4j
    to do
    so.
            Since slf4j
    isn’
    t a
    logging engine
    by itself, it’
    s also
    useful to
    see the
    top logging
    engines being
    used.It looks
    like the “winner”
    here is
    log4j – 891
    projects are
    using it.
    Next in
    line is
    Logback,with 340
    projects.While very
    respectable,this
    number still
    represents less
    than half
    of the
    projects using
    log4j.sfl4j’
    s simple
    logging implementation
    comes in
    third at 174
    projects.

            The most
    popular Java
    library today
    is slf4j –
    used by 30.7%
    of the 10,000

    projects(Tweet this)

    Spring.While Spring
    may be
    perceived by
    some as
    a more
    mature and
    less “hip”framework,
    it still
    sees tremendous
    usage,placing 15
    libraries in
    the top 100.
    Since Spring
    is an
    umbrella framework, it’
    s interesting
    to see
    which of
    its components
    are being
    used the
    most.Spring-
    test is
    the most
    used part
    of the

    framework(after the core library) with 376 entries.It’
    s followed
    by web-mvc for
    designing robust
    web applications
    with 277
    entries.After web
    functionality,
    we see
    web-
    orm with 218 entries,
    highlighting Spring’
    s key
    use case for
    building a
    DB backed
    Java web
    application.
            TDD.Right there
    with Spring
    at the
    top is
    JUnit with 3,068
    entries.This really
    shows the
    profound effect
    that Test
    Driven Development
    has had
    on the
    Java landscape.
    It seems
    that if you’
    re a
    Java developer
    posting your
    code,
    unit tests
    today are
    an absolute
    requirement.It’
    s also
    worthwhile noting
    that while
    JUnit is
    not alone
    in this

    space(TestNG, the 2 nd most popular testing framework, has 331 entries) it is by far the most dominant.
            [
    adrotate group =”11″]
    Mockito,
    a popular
    framework for
    mock based
    testing,
    has also
    gained wide
    appeal with 413 entries.EasyMock,
    another mocking
    framework,comes 2
    nd in this
    category with 231
    project entries.

    Google’
    s Guava
    framework is
    becoming mainstream – 4.8%of 10,000
    Java GitHub
    projects are

    using it(Tweet this)

    Apache Commons.
    Having looked
    at Spring, it’
    s important
    we don’
    t neglect
    Apache Commons, one
    of the
    most fundamental
    set of
    libraries within
    the language.Commons-
    io and
    Commons-
    lang are
    right there
    in the
    top 10 with 519 and 504
    entries respectively, showing
    their strong
    prevalence.
            As a
    whole Apache
    Commons have 13
    libraries in
    the top 100.Google’
    s Guava
    framework,
    which itself
    provides language

    utils(some similar to those found in Commons) is also doing very well with 483 entries,
    marking it
    as another
    key Java
    building block.
            04(1)
    Sql &
    NoSql.With NoSql
    and Big
    data being
    all the
    buzz these
    last couple

    of years(some for good reasons),it’
    s worthwhile
    looking at
    the actual
    usage numbers for
    both relational
    and NoSql
    technologies.The most
    popular Sql
    DB out
    there is
    MySql with 225
    entries.Hibernate ORM, while
    not a
    DB in
    itself,
    is also
    fairly popular
    with 181
    entries.This is
    one area
    that we
    need to
    keep in
    mind that
    as GH
    is an
    open source
    repository,
    we might
    see a
    somewhat stronger
    bias towards
    commercial DBs
    such as
    Oracle’
    s in
    a closed
    source dataset.

    Justifying the
    buzz:
    Hadoop is
    more popular
    in Java
    GitHub projects
    than Postgre

    SQL(Tweet this)

    Hadoop is
    also doing
    very well
    with 168 entries,
    showing that
    the buzz
    is justified
    when looking
    at its
    actual usage
    data.To put
    in perspective, it
    has more
    entries than

    Postgre SQL(with 121 entries),one of the most mature relational open source DBs out there.
    ElasticSearch,
    another Big
    data technology, is
    also on
    the board
    with 110
    project entries.It’
    s surprising
    to note
    that sqlite, which
    has 1,085
    entries in
    Ruby,isn’
    t in
    the Java
    top 100.
    Android.For mobile
    developers on
    GH we
    see 228
    project entries
    consuming Android
    via Maven.While this
    can signify
    that not
    a lot
    of mobile
    projects are
    placed on
    GH,it’
    s still
    a strong
    indicator that
    Java remains
    a very
    strong server
    side language.
    Surprised by
    some of
    the results?
    We know
    we were
    with some
    of them.
    Take a
    look at
    the full
    list of
    the top 100
    Java libraries
    on GitHub
    below,
    and let
    us know
    what you
    think in
    the comments
    section.We’
    d love
    to hear
    your thoughts
    and questions.

    main2(1)

    We Analyzed 30,000
    GitHub Projects –
    Here Are
    The Top 100
    Libraries in
    Java,
    JS and
    Ruby –
    read more


    Ophir Primat
    As VP
    Marketing,
    Ophir is
    in charge
    of driving
    OverOps' marketing strategies, demand generation, brand recognition and communications. Previously, Ophir was a financial journalist and editor-in-chief at Forbes Magazine. Considers dessert a full meal.

    developers
            Github
    Java
    Further Reading

    Featured Post
    Achieving Observability:
    How to
    Address the
    Unknown Unknowns
    in Your
    Application
    Get it
    Now

    Next Article

    We Analyzed 30,000
    GitHub Projects -
    Here Are
    The Top 100
    Libraries in
    Java,
    JS and
    Ruby
6
    min read
    Move Fast.
    Fix Faster.
    Prevent Rapid
    Code Changes
    From Impacting
    Customers.Identify and
    Resolve Your
    Most Critical
    Issues in
    Minutes.
            Learn More
    Developers:
    OverOps tells
    you when new
    code breaks
    in production –
    Learn more


    As Java
    developers working
    with a
    language that’
    s both
    mature yet
    highly evolving, we’
    re faced
    with a
    constant dilemma
    whenever we
    write new code –
    go with
    the hot new
    technology that
    everyone is
    talking about, or
    stick with
    a tried-and-true library?

    Since a
    very large
    part of
    Java applications
    are commercial
    in nature, it
    can sometimes
    be hard
    to separate
    the buzz
    around a new
    framework with
    the number
    of projects
    actually putting
    it to
    use.This is
    important,
    as the
    community of
    users and
    contributors around
    a framework
    is one
    of the
    strongest factors
    in determining
    its continuous
    success and
    development.

            We decided
    to use
    a data
    based approach
    to get
    more insight
    into this,
    by analyzing
    which Java
    projects developers
    are actually
    using on
    the world’
    s largest
    open repository for
    Java projects –
    GitHub.

            In our
    previous post
    we presented
    the main
    results of
    our GitHub
    research project
    and the
    top 100 libraries for JavaScript,
    Ruby and
    Java.Now let’
    s dive
    into the
    data,
    analyzing Java
    in particular.

    The Approach
    To generate
    our dataset
    we queried 10,000
    Java projects, with
    a bias
    towards the
    ones most
    favorited by
    the community, as
    a strong
    qualifying indicator
    towards their
    relative importance.
    We used
    the pom.xml,
    which is
    used by
    the vast
    majority of
    Java projects
    on GH, to
    define dependencies.
    We then
    analyzed and
    grouped those
    into categories.
    The results
    were really
    interesting.

            The Results
    The full
    list –Top 100 libraries for JavaScript,
    Ruby and
    Java
01
    Logging.The most
    popular Java
    library is
    slf4j –
    the logging
    facade framework, with 3,068
    entries.It seems
    that Java
    GH developers
    have fully
    embraced a
    decoupled approach
    towards their
    logging engine, and
    have standardized
    on slf4j
    to do
    so.
            Since slf4j
    isn’
    t a
    logging engine
    by itself, it’
    s also
    useful to
    see the
    top logging
    engines being
    used.It looks
    like the “winner”
    here is
    log4j – 891
    projects are
    using it.
    Next in
    line is
    Logback,with 340
    projects.While very
    respectable,this
    number still
    represents less
    than half
    of the
    projects using
    log4j.sfl4j’
    s simple
    logging implementation
    comes in
    third at 174
    projects.

            The most
    popular Java
    library today
    is slf4j –
    used by 30.7%
    of the 10,000

    projects(Tweet this)

    Spring.While Spring
    may be
    perceived by
    some as
    a more
    mature and
    less “hip”framework,
    it still
    sees tremendous
    usage,placing 15
    libraries in
    the top 100.
    Since Spring
    is an
    umbrella framework, it’
    s interesting
    to see
    which of
    its components
    are being
    used the
    most.Spring-
    test is
    the most
    used part
    of the

    framework(after the core library) with 376 entries.It’
    s followed
    by web-mvc for
    designing robust
    web applications
    with 277
    entries.After web
    functionality,
    we see
    web-
    orm with 218 entries,
    highlighting Spring’
    s key
    use case for
    building a
    DB backed
    Java web
    application.
            TDD.Right there
    with Spring
    at the
    top is
    JUnit with 3,068
    entries.This really
    shows the
    profound effect
    that Test
    Driven Development
    has had
    on the
    Java landscape.
    It seems
    that if you’
    re a
    Java developer
    posting your
    code,
    unit tests
    today are
    an absolute
    requirement.It’
    s also
    worthwhile noting
    that while
    JUnit is
    not alone
    in this

    space(TestNG, the 2 nd most popular testing framework, has 331 entries) it is by far the most dominant.
            [
    adrotate group =”11″]
    Mockito,
    a popular
    framework for
    mock based
    testing,
    has also
    gained wide
    appeal with 413 entries.EasyMock,
    another mocking
    framework,comes 2
    nd in this
    category with 231
    project entries.

    Google’
    s Guava
    framework is
    becoming mainstream – 4.8%of 10,000
    Java GitHub
    projects are

    using it(Tweet this)

    Apache Commons.
    Having looked
    at Spring, it’
    s important
    we don’
    t neglect
    Apache Commons, one
    of the
    most fundamental
    set of
    libraries within
    the language.Commons-
    io and
    Commons-
    lang are
    right there
    in the
    top 10 with 519 and 504
    entries respectively, showing
    their strong
    prevalence.
            As a
    whole Apache
    Commons have 13
    libraries in
    the top 100.Google’
    s Guava
    framework,
    which itself
    provides language

    utils(some similar to those found in Commons) is also doing very well with 483 entries,
    marking it
    as another
    key Java
    building block.
            04(1)
    Sql &
    NoSql.With NoSql
    and Big
    data being
    all the
    buzz these
    last couple

    of years(some for good reasons),it’
    s worthwhile
    looking at
    the actual
    usage numbers for
    both relational
    and NoSql
    technologies.The most
    popular Sql
    DB out
    there is
    MySql with 225
    entries.Hibernate ORM, while
    not a
    DB in
    itself,
    is also
    fairly popular
    with 181
    entries.This is
    one area
    that we
    need to
    keep in
    mind that
    as GH
    is an
    open source
    repository,
    we might
    see a
    somewhat stronger
    bias towards
    commercial DBs
    such as
    Oracle’
    s in
    a closed
    source dataset.

    Justifying the
    buzz:
    Hadoop is
    more popular
    in Java
    GitHub projects
    than Postgre

    SQL(Tweet this)

    Hadoop is
    also doing
    very well
    with 168 entries,
    showing that
    the buzz
    is justified
    when looking
    at its
    actual usage
    data.To put
    in perspective, it
    has more
    entries than

    Postgre SQL(with 121 entries),one of the most mature relational open source DBs out there.
    ElasticSearch,
    another Big
    data technology, is
    also on
    the board
    with 110
    project entries.It’
    s surprising
    to note
    that sqlite, which
    has 1,085
    entries in
    Ruby,isn’
    t in
    the Java
    top 100.
    Android.For mobile
    developers on
    GH we
    see 228
    project entries
    consuming Android
    via Maven.While this
    can signify
    that not
    a lot
    of mobile
    projects are
    placed on
    GH,it’
    s still
    a strong
    indicator that
    Java remains
    a very
    strong server
    side language.
    Surprised by
    some of
    the results?
    We know
    we were
    with some
    of them.
    Take a
    look at
    the full
    list of
    the top 100
    Java libraries
    on GitHub
    below,
    and let
    us know
    what you
    think in
    the comments
    section.We’
    d love
    to hear
    your thoughts
    and questions.

    main2(1)

    We Analyzed 30,000
    GitHub Projects –
    Here Are
    The Top 100
    Libraries in
    Java,
    JS and
    Ruby –
    read more


    Ophir Primat
    As VP
    Marketing,
    Ophir is
    in charge
    of driving
    OverOps' marketing strategies, demand generation, brand recognition and communications. Previously, Ophir was a financial journalist and editor-in-chief at Forbes Magazine. Considers dessert a full meal.

    developers
            Github
    Java
    Further Reading

    Featured Post
    Achieving Observability:
    How to
    Address the
    Unknown Unknowns
    in Your
    Application
    Get it
    Now

    Next Article

    We Analyzed 30,000
    GitHub Projects -
    Here Are
    The Top 100
    Libraries in
    Java,
    JS and
    Ruby
6
    min read
    Move Fast.
    Fix Faster.
    Prevent Rapid
    Code Changes
    From Impacting
    Customers.Identify and
    Resolve Your
    Most Critical
    Issues in
    Minutes.
            Learn More
    Developers:
    OverOps tells
    you when new
    code breaks
    in production –
    Learn more


    As Java
    developers working
    with a
    language that’
    s both
    mature yet
    highly evolving, we’
    re faced
    with a
    constant dilemma
    whenever we
    write new code –
    go with
    the hot new
    technology that
    everyone is
    talking about, or
    stick with
    a tried-and-true library?

    Since a
    very large
    part of
    Java applications
    are commercial
    in nature, it
    can sometimes
    be hard
    to separate
    the buzz
    around a new
    framework with
    the number
    of projects
    actually putting
    it to
    use.This is
    important,
    as the
    community of
    users and
    contributors around
    a framework
    is one
    of the
    strongest factors
    in determining
    its continuous
    success and
    development.

            We decided
    to use
    a data
    based approach
    to get
    more insight
    into this,
    by analyzing
    which Java
    projects developers
    are actually
    using on
    the world’
    s largest
    open repository for
    Java projects –
    GitHub.

            In our
    previous post
    we presented
    the main
    results of
    our GitHub
    research project
    and the
    top 100 libraries for JavaScript,
    Ruby and
    Java.Now let’
    s dive
    into the
    data,
    analyzing Java
    in particular.

    The Approach
    To generate
    our dataset
    we queried 10,000
    Java projects, with
    a bias
    towards the
    ones most
    favorited by
    the community, as
    a strong
    qualifying indicator
    towards their
    relative importance.
    We used
    the pom.xml,
    which is
    used by
    the vast
    majority of
    Java projects
    on GH, to
    define dependencies.
    We then
    analyzed and
    grouped those
    into categories.
    The results
    were really
    interesting.

            The Results
    The full
    list –Top 100 libraries for JavaScript,
    Ruby and
    Java
01
    Logging.The most
    popular Java
    library is
    slf4j –
    the logging
    facade framework, with 3,068
    entries.It seems
    that Java
    GH developers
    have fully
    embraced a
    decoupled approach
    towards their
    logging engine, and
    have standardized
    on slf4j
    to do
    so.
            Since slf4j
    isn’
    t a
    logging engine
    by itself, it’
    s also
    useful to
    see the
    top logging
    engines being
    used.It looks
    like the “winner”
    here is
    log4j – 891
    projects are
    using it.
    Next in
    line is
    Logback,with 340
    projects.While very
    respectable,this
    number still
    represents less
    than half
    of the
    projects using
    log4j.sfl4j’
    s simple
    logging implementation
    comes in
    third at 174
    projects.

            The most
    popular Java
    library today
    is slf4j –
    used by 30.7%
    of the 10,000

    projects(Tweet this)

    Spring.While Spring
    may be
    perceived by
    some as
    a more
    mature and
    less “hip”framework,
    it still
    sees tremendous
    usage,placing 15
    libraries in
    the top 100.
    Since Spring
    is an
    umbrella framework, it’
    s interesting
    to see
    which of
    its components
    are being
    used the
    most.Spring-
    test is
    the most
    used part
    of the

    framework(after the core library) with 376 entries.It’
    s followed
    by web-mvc for
    designing robust
    web applications
    with 277
    entries.After web
    functionality,
    we see
    web-
    orm with 218 entries,
    highlighting Spring’
    s key
    use case for
    building a
    DB backed
    Java web
    application.
            TDD.Right there
    with Spring
    at the
    top is
    JUnit with 3,068
    entries.This really
    shows the
    profound effect
    that Test
    Driven Development
    has had
    on the
    Java landscape.
    It seems
    that if you’
    re a
    Java developer
    posting your
    code,
    unit tests
    today are
    an absolute
    requirement.It’
    s also
    worthwhile noting
    that while
    JUnit is
    not alone
    in this

    space(TestNG, the 2 nd most popular testing framework, has 331 entries) it is by far the most dominant.
            [
    adrotate group =”11″]
    Mockito,
    a popular
    framework for
    mock based
    testing,
    has also
    gained wide
    appeal with 413 entries.EasyMock,
    another mocking
    framework,comes 2
    nd in this
    category with 231
    project entries.

    Google’
    s Guava
    framework is
    becoming mainstream – 4.8%of 10,000
    Java GitHub
    projects are

    using it(Tweet this)

    Apache Commons.
    Having looked
    at Spring, it’
    s important
    we don’
    t neglect
    Apache Commons, one
    of the
    most fundamental
    set of
    libraries within
    the language.Commons-
    io and
    Commons-
    lang are
    right there
    in the
    top 10 with 519 and 504
    entries respectively, showing
    their strong
    prevalence.
            As a
    whole Apache
    Commons have 13
    libraries in
    the top 100.Google’
    s Guava
    framework,
    which itself
    provides language

    utils(some similar to those found in Commons) is also doing very well with 483 entries,
    marking it
    as another
    key Java
    building block.
            04(1)
    Sql &
    NoSql.With NoSql
    and Big
    data being
    all the
    buzz these
    last couple

    of years(some for good reasons),it’
    s worthwhile
    looking at
    the actual
    usage numbers for
    both relational
    and NoSql
    technologies.The most
    popular Sql
    DB out
    there is
    MySql with 225
    entries.Hibernate ORM, while
    not a
    DB in
    itself,
    is also
    fairly popular
    with 181
    entries.This is
    one area
    that we
    need to
    keep in
    mind that
    as GH
    is an
    open source
    repository,
    we might
    see a
    somewhat stronger
    bias towards
    commercial DBs
    such as
    Oracle’
    s in
    a closed
    source dataset.

    Justifying the
    buzz:
    Hadoop is
    more popular
    in Java
    GitHub projects
    than Postgre

    SQL(Tweet this)

    Hadoop is
    also doing
    very well
    with 168 entries,
    showing that
    the buzz
    is justified
    when looking
    at its
    actual usage
    data.To put
    in perspective, it
    has more
    entries than

    Postgre SQL(with 121 entries),one of the most mature relational open source DBs out there.
    ElasticSearch,
    another Big
    data technology, is
    also on
    the board
    with 110
    project entries.It’
    s surprising
    to note
    that sqlite, which
    has 1,085
    entries in
    Ruby,isn’
    t in
    the Java
    top 100.
    Android.For mobile
    developers on
    GH we
    see 228
    project entries
    consuming Android
    via Maven.While this
    can signify
    that not
    a lot
    of mobile
    projects are
    placed on
    GH,it’
    s still
    a strong
    indicator that
    Java remains
    a very
    strong server
    side language.
    Surprised by
    some of
    the results?
    We know
    we were
    with some
    of them.
    Take a
    look at
    the full
    list of
    the top 100
    Java libraries
    on GitHub
    below,
    and let
    us know
    what you
    think in
    the comments
    section.We’
    d love
    to hear
    your thoughts
    and questions.

    main2(1)

    We Analyzed 30,000
    GitHub Projects –
    Here Are
    The Top 100
    Libraries in
    Java,
    JS and
    Ruby –
    read more


    Ophir Primat
    As VP
    Marketing,
    Ophir is
    in charge
    of driving
    OverOps' marketing strategies, demand generation, brand recognition and communications. Previously, Ophir was a financial journalist and editor-in-chief at Forbes Magazine. Considers dessert a full meal.

    developers
            Github
    Java
    Further Reading

    Featured Post
    Achieving Observability:
    How to
    Address the
    Unknown Unknowns
    in Your
    Application
    Get it
    Now

    Next Article

    We Analyzed 30,000
    GitHub Projects -
    Here Are
    The Top 100
    Libraries in
    Java,
    JS and
    Ruby
6
    min read
    Move Fast.
    Fix Faster.
    Prevent Rapid
    Code Changes
    From Impacting
    Customers.Identify and
    Resolve Your
    Most Critical
    Issues in
    Minutes.
            Learn More
    Developers:
    OverOps tells
    you when new
    code breaks
    in production –
    Learn more


    As Java
    developers working
    with a
    language that’
    s both
    mature yet
    highly evolving, we’
    re faced
    with a
    constant dilemma
    whenever we
    write new code –
    go with
    the hot new
    technology that
    everyone is
    talking about, or
    stick with
    a tried-and-true library?

    Since a
    very large
    part of
    Java applications
    are commercial
    in nature, it
    can sometimes
    be hard
    to separate
    the buzz
    around a new
    framework with
    the number
    of projects
    actually putting
    it to
    use.This is
    important,
    as the
    community of
    users and
    contributors around
    a framework
    is one
    of the
    strongest factors
    in determining
    its continuous
    success and
    development.

            We decided
    to use
    a data
    based approach
    to get
    more insight
    into this,
    by analyzing
    which Java
    projects developers
    are actually
    using on
    the world’
    s largest
    open repository for
    Java projects –
    GitHub.

            In our
    previous post
    we presented
    the main
    results of
    our GitHub
    research project
    and the
    top 100 libraries for JavaScript,
    Ruby and
    Java.Now let’
    s dive
    into the
    data,
    analyzing Java
    in particular.

    The Approach
    To generate
    our dataset
    we queried 10,000
    Java projects, with
    a bias
    towards the
    ones most
    favorited by
    the community, as
    a strong
    qualifying indicator
    towards their
    relative importance.
    We used
    the pom.xml,
    which is
    used by
    the vast
    majority of
    Java projects
    on GH, to
    define dependencies.
    We then
    analyzed and
    grouped those
    into categories.
    The results
    were really
    interesting.

            The Results
    The full
    list –Top 100 libraries for JavaScript,
    Ruby and
    Java
01
    Logging.The most
    popular Java
    library is
    slf4j –
    the logging
    facade framework, with 3,068
    entries.It seems
    that Java
    GH developers
    have fully
    embraced a
    decoupled approach
    towards their
    logging engine, and
    have standardized
    on slf4j
    to do
    so.
            Since slf4j
    isn’
    t a
    logging engine
    by itself, it’
    s also
    useful to
    see the
    top logging
    engines being
    used.It looks
    like the “winner”
    here is
    log4j – 891
    projects are
    using it.
    Next in
    line is
    Logback,with 340
    projects.While very
    respectable,this
    number still
    represents less
    than half
    of the
    projects using
    log4j.sfl4j’
    s simple
    logging implementation
    comes in
    third at 174
    projects.

            The most
    popular Java
    library today
    is slf4j –
    used by 30.7%
    of the 10,000

    projects(Tweet this)

    Spring.While Spring
    may be
    perceived by
    some as
    a more
    mature and
    less “hip”framework,
    it still
    sees tremendous
    usage,placing 15
    libraries in
    the top 100.
    Since Spring
    is an
    umbrella framework, it’
    s interesting
    to see
    which of
    its components
    are being
    used the
    most.Spring-
    test is
    the most
    used part
    of the

    framework(after the core library) with 376 entries.It’
    s followed
    by web-mvc for
    designing robust
    web applications
    with 277
    entries.After web
    functionality,
    we see
    web-
    orm with 218 entries,
    highlighting Spring’
    s key
    use case for
    building a
    DB backed
    Java web
    application.
            TDD.Right there
    with Spring
    at the
    top is
    JUnit with 3,068
    entries.This really
    shows the
    profound effect
    that Test
    Driven Development
    has had
    on the
    Java landscape.
    It seems
    that if you’
    re a
    Java developer
    posting your
    code,
    unit tests
    today are
    an absolute
    requirement.It’
    s also
    worthwhile noting
    that while
    JUnit is
    not alone
    in this

    space(TestNG, the 2 nd most popular testing framework, has 331 entries) it is by far the most dominant.
            [
    adrotate group =”11″]
    Mockito,
    a popular
    framework for
    mock based
    testing,
    has also
    gained wide
    appeal with 413 entries.EasyMock,
    another mocking
    framework,comes 2
    nd in this
    category with 231
    project entries.

    Google’
    s Guava
    framework is
    becoming mainstream – 4.8%of 10,000
    Java GitHub
    projects are

    using it(Tweet this)

    Apache Commons.
    Having looked
    at Spring, it’
    s important
    we don’
    t neglect
    Apache Commons, one
    of the
    most fundamental
    set of
    libraries within
    the language.Commons-
    io and
    Commons-
    lang are
    right there
    in the
    top 10 with 519 and 504
    entries respectively, showing
    their strong
    prevalence.
            As a
    whole Apache
    Commons have 13
    libraries in
    the top 100.Google’
    s Guava
    framework,
    which itself
    provides language

    utils(some similar to those found in Commons) is also doing very well with 483 entries,
    marking it
    as another
    key Java
    building block.
            04(1)
    Sql &
    NoSql.With NoSql
    and Big
    data being
    all the
    buzz these
    last couple

    of years(some for good reasons),it’
    s worthwhile
    looking at
    the actual
    usage numbers for
    both relational
    and NoSql
    technologies.The most
    popular Sql
    DB out
    there is
    MySql with 225
    entries.Hibernate ORM, while
    not a
    DB in
    itself,
    is also
    fairly popular
    with 181
    entries.This is
    one area
    that we
    need to
    keep in
    mind that
    as GH
    is an
    open source
    repository,
    we might
    see a
    somewhat stronger
    bias towards
    commercial DBs
    such as
    Oracle’
    s in
    a closed
    source dataset.

    Justifying the
    buzz:
    Hadoop is
    more popular
    in Java
    GitHub projects
    than Postgre

    SQL(Tweet this)

    Hadoop is
    also doing
    very well
    with 168 entries,
    showing that
    the buzz
    is justified
    when looking
    at its
    actual usage
    data.To put
    in perspective, it
    has more
    entries than

    Postgre SQL(with 121 entries),one of the most mature relational open source DBs out there.
    ElasticSearch,
    another Big
    data technology, is
    also on
    the board
    with 110
    project entries.It’
    s surprising
    to note
    that sqlite, which
    has 1,085
    entries in
    Ruby,isn’
    t in
    the Java
    top 100.
    Android.For mobile
    developers on
    GH we
    see 228
    project entries
    consuming Android
    via Maven.While this
    can signify
    that not
    a lot
    of mobile
    projects are
    placed on
    GH,it’
    s still
    a strong
    indicator that
    Java remains
    a very
    strong server
    side language.
    Surprised by
    some of
    the results?
    We know
    we were
    with some
    of them.
    Take a
    look at
    the full
    list of
    the top 100
    Java libraries
    on GitHub
    below,
    and let
    us know
    what you
    think in
    the comments
    section.We’
    d love
    to hear
    your thoughts
    and questions.

    main2(1)

    We Analyzed 30,000
    GitHub Projects –
    Here Are
    The Top 100
    Libraries in
    Java,
    JS and
    Ruby –
    read more


    Ophir Primat
    As VP
    Marketing,
    Ophir is
    in charge
    of driving
    OverOps' marketing strategies, demand generation, brand recognition and communications. Previously, Ophir was a financial journalist and editor-in-chief at Forbes Magazine. Considers dessert a full meal.

    developers
            Github
    Java
    Further Reading

    Featured Post
    Achieving Observability:
    How to
    Address the
    Unknown Unknowns
    in Your
    Application
    Get it
    Now

    Next Article

    We Analyzed 30,000
    GitHub Projects -
    Here Are
    The Top 100
    Libraries in
    Java,
    JS and
    Ruby
6
    min read
    Move Fast.
    Fix Faster.
    Prevent Rapid
    Code Changes
    From Impacting
    Customers.Identify and
    Resolve Your
    Most Critical
    Issues in
    Minutes.
            Learn More
    Developers:
    OverOps tells
    you when new
    code breaks
    in production –
    Learn more


    As Java
    developers working
    with a
    language that’
    s both
    mature yet
    highly evolving, we’
    re faced
    with a
    constant dilemma
    whenever we
    write new code –
    go with
    the hot new
    technology that
    everyone is
    talking about, or
    stick with
    a tried-and-true library?

    Since a
    very large
    part of
    Java applications
    are commercial
    in nature, it
    can sometimes
    be hard
    to separate
    the buzz
    around a new
    framework with
    the number
    of projects
    actually putting
    it to
    use.This is
    important,
    as the
    community of
    users and
    contributors around
    a framework
    is one
    of the
    strongest factors
    in determining
    its continuous
    success and
    development.

            We decided
    to use
    a data
    based approach
    to get
    more insight
    into this,
    by analyzing
    which Java
    projects developers
    are actually
    using on
    the world’
    s largest
    open repository for
    Java projects –
    GitHub.

            In our
    previous post
    we presented
    the main
    results of
    our GitHub
    research project
    and the
    top 100 libraries for JavaScript,
    Ruby and
    Java.Now let’
    s dive
    into the
    data,
    analyzing Java
    in particular.

    The Approach
    To generate
    our dataset
    we queried 10,000
    Java projects, with
    a bias
    towards the
    ones most
    favorited by
    the community, as
    a strong
    qualifying indicator
    towards their
    relative importance.
    We used
    the pom.xml,
    which is
    used by
    the vast
    majority of
    Java projects
    on GH, to
    define dependencies.
    We then
    analyzed and
    grouped those
    into categories.
    The results
    were really
    interesting.

            The Results
    The full
    list –Top 100 libraries for JavaScript,
    Ruby and
    Java
01
    Logging.The most
    popular Java
    library is
    slf4j –
    the logging
    facade framework, with 3,068
    entries.It seems
    that Java
    GH developers
    have fully
    embraced a
    decoupled approach
    towards their
    logging engine, and
    have standardized
    on slf4j
    to do
    so.
            Since slf4j
    isn’
    t a
    logging engine
    by itself, it’
    s also
    useful to
    see the
    top logging
    engines being
    used.It looks
    like the “winner”
    here is
    log4j – 891
    projects are
    using it.
    Next in
    line is
    Logback,with 340
    projects.While very
    respectable,this
    number still
    represents less
    than half
    of the
    projects using
    log4j.sfl4j’
    s simple
    logging implementation
    comes in
    third at 174
    projects.

            The most
    popular Java
    library today
    is slf4j –
    used by 30.7%
    of the 10,000

    projects(Tweet this)

    Spring.While Spring
    may be
    perceived by
    some as
    a more
    mature and
    less “hip”framework,
    it still
    sees tremendous
    usage,placing 15
    libraries in
    the top 100.
    Since Spring
    is an
    umbrella framework, it’
    s interesting
    to see
    which of
    its components
    are being
    used the
    most.Spring-
    test is
    the most
    used part
    of the

    framework(after the core library) with 376 entries.It’
    s followed
    by web-mvc for
    designing robust
    web applications
    with 277
    entries.After web
    functionality,
    we see
    web-
    orm with 218 entries,
    highlighting Spring’
    s key
    use case for
    building a
    DB backed
    Java web
    application.
            TDD.Right there
    with Spring
    at the
    top is
    JUnit with 3,068
    entries.This really
    shows the
    profound effect
    that Test
    Driven Development
    has had
    on the
    Java landscape.
    It seems
    that if you’
    re a
    Java developer
    posting your
    code,
    unit tests
    today are
    an absolute
    requirement.It’
    s also
    worthwhile noting
    that while
    JUnit is
    not alone
    in this

    space(TestNG, the 2 nd most popular testing framework, has 331 entries) it is by far the most dominant.
            [
    adrotate group =”11″]
    Mockito,
    a popular
    framework for
    mock based
    testing,
    has also
    gained wide
    appeal with 413 entries.EasyMock,
    another mocking
    framework,comes 2
    nd in this
    category with 231
    project entries.

    Google’
    s Guava
    framework is
    becoming mainstream – 4.8%of 10,000
    Java GitHub
    projects are

    using it(Tweet this)

    Apache Commons.
    Having looked
    at Spring, it’
    s important
    we don’
    t neglect
    Apache Commons, one
    of the
    most fundamental
    set of
    libraries within
    the language.Commons-
    io and
    Commons-
    lang are
    right there
    in the
    top 10 with 519 and 504
    entries respectively, showing
    their strong
    prevalence.
            As a
    whole Apache
    Commons have 13
    libraries in
    the top 100.Google’
    s Guava
    framework,
    which itself
    provides language

    utils(some similar to those found in Commons) is also doing very well with 483 entries,
    marking it
    as another
    key Java
    building block.
            04(1)
    Sql &
    NoSql.With NoSql
    and Big
    data being
    all the
    buzz these
    last couple

    of years(some for good reasons),it’
    s worthwhile
    looking at
    the actual
    usage numbers for
    both relational
    and NoSql
    technologies.The most
    popular Sql
    DB out
    there is
    MySql with 225
    entries.Hibernate ORM, while
    not a
    DB in
    itself,
    is also
    fairly popular
    with 181
    entries.This is
    one area
    that we
    need to
    keep in
    mind that
    as GH
    is an
    open source
    repository,
    we might
    see a
    somewhat stronger
    bias towards
    commercial DBs
    such as
    Oracle’
    s in
    a closed
    source dataset.

    Justifying the
    buzz:
    Hadoop is
    more popular
    in Java
    GitHub projects
    than Postgre

    SQL(Tweet this)

    Hadoop is
    also doing
    very well
    with 168 entries,
    showing that
    the buzz
    is justified
    when looking
    at its
    actual usage
    data.To put
    in perspective, it
    has more
    entries than

    Postgre SQL(with 121 entries),one of the most mature relational open source DBs out there.
    ElasticSearch,
    another Big
    data technology, is
    also on
    the board
    with 110
    project entries.It’
    s surprising
    to note
    that sqlite, which
    has 1,085
    entries in
    Ruby,isn’
    t in
    the Java
    top 100.
    Android.For mobile
    developers on
    GH we
    see 228
    project entries
    consuming Android
    via Maven.While this
    can signify
    that not
    a lot
    of mobile
    projects are
    placed on
    GH,it’
    s still
    a strong
    indicator that
    Java remains
    a very
    strong server
    side language.
    Surprised by
    some of
    the results?
    We know
    we were
    with some
    of them.
    Take a
    look at
    the full
    list of
    the top 100
    Java libraries
    on GitHub
    below,
    and let
    us know
    what you
    think in
    the comments
    section.We’
    d love
    to hear
    your thoughts
    and questions.

    main2(1)

    We Analyzed 30,000
    GitHub Projects –
    Here Are
    The Top 100
    Libraries in
    Java,
    JS and
    Ruby –
    read more


    Ophir Primat
    As VP
    Marketing,
    Ophir is
    in charge
    of driving
    OverOps' marketing strategies, demand generation, brand recognition and communications. Previously, Ophir was a financial journalist and editor-in-chief at Forbes Magazine. Considers dessert a full meal.

    developers
            Github
    Java
    Further Reading

    Featured Post
    Achieving Observability:
    How to
    Address the
    Unknown Unknowns
    in Your
    Application
    Get it
    Now

    Next Article

    We Analyzed 30,000
    GitHub Projects -
    Here Are
    The Top 100
    Libraries in
    Java,
    JS and
    Ruby
6
    min read
    Move Fast.
    Fix Faster.
    Prevent Rapid
    Code Changes
    From Impacting
    Customers.Identify and
    Resolve Your
    Most Critical
    Issues in
    Minutes.
            Learn More
    Developers:
    OverOps tells
    you when new
    code breaks
    in production –
    Learn more


    As Java
    developers working
    with a
    language that’
    s both
    mature yet
    highly evolving, we’
    re faced
    with a
    constant dilemma
    whenever we
    write new code –
    go with
    the hot new
    technology that
    everyone is
    talking about, or
    stick with
    a tried-and-true library?

    Since a
    very large
    part of
    Java applications
    are commercial
    in nature, it
    can sometimes
    be hard
    to separate
    the buzz
    around a new
    framework with
    the number
    of projects
    actually putting
    it to
    use.This is
    important,
    as the
    community of
    users and
    contributors around
    a framework
    is one
    of the
    strongest factors
    in determining
    its continuous
    success and
    development.

            We decided
    to use
    a data
    based approach
    to get
    more insight
    into this,
    by analyzing
    which Java
    projects developers
    are actually
    using on
    the world’
    s largest
    open repository for
    Java projects –
    GitHub.

            In our
    previous post
    we presented
    the main
    results of
    our GitHub
    research project
    and the
    top 100 libraries for JavaScript,
    Ruby and
    Java.Now let’
    s dive
    into the
    data,
    analyzing Java
    in particular.

    The Approach
    To generate
    our dataset
    we queried 10,000
    Java projects, with
    a bias
    towards the
    ones most
    favorited by
    the community, as
    a strong
    qualifying indicator
    towards their
    relative importance.
    We used
    the pom.xml,
    which is
    used by
    the vast
    majority of
    Java projects
    on GH, to
    define dependencies.
    We then
    analyzed and
    grouped those
    into categories.
    The results
    were really
    interesting.

            The Results
    The full
    list –Top 100 libraries for JavaScript,
    Ruby and
    Java
01
    Logging.The most
    popular Java
    library is
    slf4j –
    the logging
    facade framework, with 3,068
    entries.It seems
    that Java
    GH developers
    have fully
    embraced a
    decoupled approach
    towards their
    logging engine, and
    have standardized
    on slf4j
    to do
    so.
            Since slf4j
    isn’
    t a
    logging engine
    by itself, it’
    s also
    useful to
    see the
    top logging
    engines being
    used.It looks
    like the “winner”
    here is
    log4j – 891
    projects are
    using it.
    Next in
    line is
    Logback,with 340
    projects.While very
    respectable,this
    number still
    represents less
    than half
    of the
    projects using
    log4j.sfl4j’
    s simple
    logging implementation
    comes in
    third at 174
    projects.

            The most
    popular Java
    library today
    is slf4j –
    used by 30.7%
    of the 10,000

    projects(Tweet this)

    Spring.While Spring
    may be
    perceived by
    some as
    a more
    mature and
    less “hip”framework,
    it still
    sees tremendous
    usage,placing 15
    libraries in
    the top 100.
    Since Spring
    is an
    umbrella framework, it’
    s interesting
    to see
    which of
    its components
    are being
    used the
    most.Spring-
    test is
    the most
    used part
    of the

    framework(after the core library) with 376 entries.It’
    s followed
    by web-mvc for
    designing robust
    web applications
    with 277
    entries.After web
    functionality,
    we see
    web-
    orm with 218 entries,
    highlighting Spring’
    s key
    use case for
    building a
    DB backed
    Java web
    application.
            TDD.Right there
    with Spring
    at the
    top is
    JUnit with 3,068
    entries.This really
    shows the
    profound effect
    that Test
    Driven Development
    has had
    on the
    Java landscape.
    It seems
    that if you’
    re a
    Java developer
    posting your
    code,
    unit tests
    today are
    an absolute
    requirement.It’
    s also
    worthwhile noting
    that while
    JUnit is
    not alone
    in this

    space(TestNG, the 2 nd most popular testing framework, has 331 entries) it is by far the most dominant.
            [
    adrotate group =”11″]
    Mockito,
    a popular
    framework for
    mock based
    testing,
    has also
    gained wide
    appeal with 413 entries.EasyMock,
    another mocking
    framework,comes 2
    nd in this
    category with 231
    project entries.

    Google’
    s Guava
    framework is
    becoming mainstream – 4.8%of 10,000
    Java GitHub
    projects are

    using it(Tweet this)

    Apache Commons.
    Having looked
    at Spring, it’
    s important
    we don’
    t neglect
    Apache Commons, one
    of the
    most fundamental
    set of
    libraries within
    the language.Commons-
    io and
    Commons-
    lang are
    right there
    in the
    top 10 with 519 and 504
    entries respectively, showing
    their strong
    prevalence.
            As a
    whole Apache
    Commons have 13
    libraries in
    the top 100.Google’
    s Guava
    framework,
    which itself
    provides language

    utils(some similar to those found in Commons) is also doing very well with 483 entries,
    marking it
    as another
    key Java
    building block.
            04(1)
    Sql &
    NoSql.With NoSql
    and Big
    data being
    all the
    buzz these
    last couple

    of years(some for good reasons),it’
    s worthwhile
    looking at
    the actual
    usage numbers for
    both relational
    and NoSql
    technologies.The most
    popular Sql
    DB out
    there is
    MySql with 225
    entries.Hibernate ORM, while
    not a
    DB in
    itself,
    is also
    fairly popular
    with 181
    entries.This is
    one area
    that we
    need to
    keep in
    mind that
    as GH
    is an
    open source
    repository,
    we might
    see a
    somewhat stronger
    bias towards
    commercial DBs
    such as
    Oracle’
    s in
    a closed
    source dataset.

    Justifying the
    buzz:
    Hadoop is
    more popular
    in Java
    GitHub projects
    than Postgre

    SQL(Tweet this)

    Hadoop is
    also doing
    very well
    with 168 entries,
    showing that
    the buzz
    is justified
    when looking
    at its
    actual usage
    data.To put
    in perspective, it
    has more
    entries than

    Postgre SQL(with 121 entries),one of the most mature relational open source DBs out there.
    ElasticSearch,
    another Big
    data technology, is
    also on
    the board
    with 110
    project entries.It’
    s surprising
    to note
    that sqlite, which
    has 1,085
    entries in
    Ruby,isn’
    t in
    the Java
    top 100.
    Android.For mobile
    developers on
    GH we
    see 228
    project entries
    consuming Android
    via Maven.While this
    can signify
    that not
    a lot
    of mobile
    projects are
    placed on
    GH,it’
    s still
    a strong
    indicator that
    Java remains
    a very
    strong server
    side language.
    Surprised by
    some of
    the results?
    We know
    we were
    with some
    of them.
    Take a
    look at
    the full
    list of
    the top 100
    Java libraries
    on GitHub
    below,
    and let
    us know
    what you
    think in
    the comments
    section.We’
    d love
    to hear
    your thoughts
    and questions.

    main2(1)

    We Analyzed 30,000
    GitHub Projects –
    Here Are
    The Top 100
    Libraries in
    Java,
    JS and
    Ruby –
    read more


    Ophir Primat
    As VP
    Marketing,
    Ophir is
    in charge
    of driving
    OverOps' marketing strategies, demand generation, brand recognition and communications. Previously, Ophir was a financial journalist and editor-in-chief at Forbes Magazine. Considers dessert a full meal.

    developers
            Github
    Java
    Further Reading

    Featured Post
    Achieving Observability:
    How to
    Address the
    Unknown Unknowns
    in Your
    Application
    Get it
    Now

    Next Article

    We Analyzed 30,000
    GitHub Projects -
    Here Are
    The Top 100
    Libraries in
    Java,
    JS and
    Ruby
6
    min read
    Move Fast.
    Fix Faster.
    Prevent Rapid
    Code Changes
    From Impacting
    Customers.Identify and
    Resolve Your
    Most Critical
    Issues in
    Minutes.
            Learn More

    Developers:
    OverOps tells
    you when new
    code breaks
    in production –
    Learn more


    As Java
    developers working
    with a
    language that’
    s both
    mature yet
    highly evolving, we’
    re faced
    with a
    constant dilemma
    whenever we
    write new code –
    go with
    the hot new
    technology that
    everyone is
    talking about, or
    stick with
    a tried-and-true library?

    Since a
    very large
    part of
    Java applications
    are commercial
    in nature, it
    can sometimes
    be hard
    to separate
    the buzz
    around a new
    framework with
    the number
    of projects
    actually putting
    it to
    use.This is
    important,
    as the
    community of
    users and
    contributors around
    a framework
    is one
    of the
    strongest factors
    in determining
    its continuous
    success and
    development.

            We decided
    to use
    a data
    based approach
    to get
    more insight
    into this,
    by analyzing
    which Java
    projects developers
    are actually
    using on
    the world’
    s largest
    open repository for
    Java projects –
    GitHub.

            In our
    previous post
    we presented
    the main
    results of
    our GitHub
    research project
    and the
    top 100 libraries for JavaScript,
    Ruby and
    Java.Now let’
    s dive
    into the
    data,
    analyzing Java
    in particular.

    The Approach
    To generate
    our dataset
    we queried 10,000
    Java projects, with
    a bias
    towards the
    ones most
    favorited by
    the community, as
    a strong
    qualifying indicator
    towards their
    relative importance.
    We used
    the pom.xml,
    which is
    used by
    the vast
    majority of
    Java projects
    on GH, to
    define dependencies.
    We then
    analyzed and
    grouped those
    into categories.
    The results
    were really
    interesting.

            The Results
    The full
    list –Top 100 libraries for JavaScript,
    Ruby and
    Java
01
    Logging.The most
    popular Java
    library is
    slf4j –
    the logging
    facade framework, with 3,068
    entries.It seems
    that Java
    GH developers
    have fully
    embraced a
    decoupled approach
    towards their
    logging engine, and
    have standardized
    on slf4j
    to do
    so.
            Since slf4j
    isn’
    t a
    logging engine
    by itself, it’
    s also
    useful to
    see the
    top logging
    engines being
    used.It looks
    like the “winner”
    here is
    log4j – 891
    projects are
    using it.
    Next in
    line is
    Logback,with 340
    projects.While very
    respectable,this
    number still
    represents less
    than half
    of the
    projects using
    log4j.sfl4j’
    s simple
    logging implementation
    comes in
    third at 174
    projects.

            The most
    popular Java
    library today
    is slf4j –
    used by 30.7%
    of the 10,000

    projects(Tweet this)

    Spring.While Spring
    may be
    perceived by
    some as
    a more
    mature and
    less “hip”framework,
    it still
    sees tremendous
    usage,placing 15
    libraries in
    the top 100.
    Since Spring
    is an
    umbrella framework, it’
    s interesting
    to see
    which of
    its components
    are being
    used the
    most.Spring-
    test is
    the most
    used part
    of the

    framework(after the core library) with 376 entries.It’
    s followed
    by web-mvc for
    designing robust
    web applications
    with 277
    entries.After web
    functionality,
    we see
    web-
    orm with 218 entries,
    highlighting Spring’
    s key
    use case for
    building a
    DB backed
    Java web
    application.
            TDD.Right there
    with Spring
    at the
    top is
    JUnit with 3,068
    entries.This really
    shows the
    profound effect
    that Test
    Driven Development
    has had
    on the
    Java landscape.
    It seems
    that if you’
    re a
    Java developer
    posting your
    code,
    unit tests
    today are
    an absolute
    requirement.It’
    s also
    worthwhile noting
    that while
    JUnit is
    not alone
    in this

    space(TestNG, the 2 nd most popular testing framework, has 331 entries) it is by far the most dominant.
            [
    adrotate group =”11″]
    Mockito,
    a popular
    framework for
    mock based
    testing,
    has also
    gained wide
    appeal with 413 entries.EasyMock,
    another mocking
    framework,comes 2
    nd in this
    category with 231
    project entries.

    Google’
    s Guava
    framework is
    becoming mainstream – 4.8%of 10,000
    Java GitHub
    projects are

    using it(Tweet this)

    Apache Commons.
    Having looked
    at Spring, it’
    s important
    we don’
    t neglect
    Apache Commons, one
    of the
    most fundamental
    set of
    libraries within
    the language.Commons-
    io and
    Commons-
    lang are
    right there
    in the
    top 10 with 519 and 504
    entries respectively, showing
    their strong
    prevalence.
            As a
    whole Apache
    Commons have 13
    libraries in
    the top 100.Google’
    s Guava
    framework,
    which itself
    provides language

    utils(some similar to those found in Commons) is also doing very well with 483 entries,
    marking it
    as another
    key Java
    building block.
            04(1)
    Sql &
    NoSql.With NoSql
    and Big
    data being
    all the
    buzz these
    last couple

    of years(some for good reasons),it’
    s worthwhile
    looking at
    the actual
    usage numbers for
    both relational
    and NoSql
    technologies.The most
    popular Sql
    DB out
    there is
    MySql with 225
    entries.Hibernate ORM, while
    not a
    DB in
    itself,
    is also
    fairly popular
    with 181
    entries.This is
    one area
    that we
    need to
    keep in
    mind that
    as GH
    is an
    open source
    repository,
    we might
    see a
    somewhat stronger
    bias towards
    commercial DBs
    such as
    Oracle’
    s in
    a closed
    source dataset.

    Justifying the
    buzz:
    Hadoop is
    more popular
    in Java
    GitHub projects
    than Postgre

    SQL(Tweet this)

    Hadoop is
    also doing
    very well
    with 168 entries,
    showing that
    the buzz
    is justified
    when looking
    at its
    actual usage
    data.To put
    in perspective, it
    has more
    entries than

    Postgre SQL(with 121 entries),one of the most mature relational open source DBs out there.
    ElasticSearch,
    another Big
    data technology, is
    also on
    the board
    with 110
    project entries.It’
    s surprising
    to note
    that sqlite, which
    has 1,085
    entries in
    Ruby,isn’
    t in
    the Java
    top 100.
    Android.For mobile
    developers on
    GH we
    see 228
    project entries
    consuming Android
    via Maven.While this
    can signify
    that not
    a lot
    of mobile
    projects are
    placed on
    GH,it’
    s still
    a strong
    indicator that
    Java remains
    a very
    strong server
    side language.
    Surprised by
    some of
    the results?
    We know
    we were
    with some
    of them.
    Take a
    look at
    the full
    list of
    the top 100
    Java libraries
    on GitHub
    below,
    and let
    us know
    what you
    think in
    the comments
    section.We’
    d love
    to hear
    your thoughts
    and questions.

    main2(1)

    We Analyzed 30,000
    GitHub Projects –
    Here Are
    The Top 100
    Libraries in
    Java,
    JS and
    Ruby –
    read more


    Ophir Primat
    As VP
    Marketing,
    Ophir is
    in charge
    of driving
    OverOps' marketing strategies, demand generation, brand recognition and communications. Previously, Ophir was a financial journalist and editor-in-chief at Forbes Magazine. Considers dessert a full meal.

    developers
            Github
    Java
    Further Reading

    Featured Post
    Achieving Observability:
    How to
    Address the
    Unknown Unknowns
    in Your
    Application
    Get it
    Now

    Next Article

    We Analyzed 30,000
    GitHub Projects -
    Here Are
    The Top 100
    Libraries in
    Java,
    JS and
    Ruby
6
    min read
    Move Fast.
    Fix Faster.
    Prevent Rapid
    Code Changes
    From Impacting
    Customers.Identify and
    Resolve Your
    Most Critical
    Issues in
    Minutes.
            Learn More

    Developers:
    OverOps tells
    you when new
    code breaks
    in production –
    Learn more


    As Java
    developers working
    with a
    language that’
    s both
    mature yet
    highly evolving, we’
    re faced
    with a
    constant dilemma
    whenever we
    write new code –
    go with
    the hot new
    technology that
    everyone is
    talking about, or
    stick with
    a tried-and-true library?

    Since a
    very large
    part of
    Java applications
    are commercial
    in nature, it
    can sometimes
    be hard
    to separate
    the buzz
    around a new
    framework with
    the number
    of projects
    actually putting
    it to
    use.This is
    important,
    as the
    community of
    users and
    contributors around
    a framework
    is one
    of the
    strongest factors
    in determining
    its continuous
    success and
    development.

            We decided
    to use
    a data
    based approach
    to get
    more insight
    into this,
    by analyzing
    which Java
    projects developers
    are actually
    using on
    the world’
    s largest
    open repository for
    Java projects –
    GitHub.

            In our
    previous post
    we presented
    the main
    results of
    our GitHub
    research project
    and the
    top 100 libraries for JavaScript,
    Ruby and
    Java.Now let’
    s dive
    into the
    data,
    analyzing Java
    in particular.

    The Approach
    To generate
    our dataset
    we queried 10,000
    Java projects, with
    a bias
    towards the
    ones most
    favorited by
    the community, as
    a strong
    qualifying indicator
    towards their
    relative importance.
    We used
    the pom.xml,
    which is
    used by
    the vast
    majority of
    Java projects
    on GH, to
    define dependencies.
    We then
    analyzed and
    grouped those
    into categories.
    The results
    were really
    interesting.

            The Results
    The full
    list –Top 100 libraries for JavaScript,
    Ruby and
    Java
01
    Logging.The most
    popular Java
    library is
    slf4j –
    the logging
    facade framework, with 3,068
    entries.It seems
    that Java
    GH developers
    have fully
    embraced a
    decoupled approach
    towards their
    logging engine, and
    have standardized
    on slf4j
    to do
    so.
            Since slf4j
    isn’
    t a
    logging engine
    by itself, it’
    s also
    useful to
    see the
    top logging
    engines being
    used.It looks
    like the “winner”
    here is
    log4j – 891
    projects are
    using it.
    Next in
    line is
    Logback,with 340
    projects.While very
    respectable,this
    number still
    represents less
    than half
    of the
    projects using
    log4j.sfl4j’
    s simple
    logging implementation
    comes in
    third at 174
    projects.

            The most
    popular Java
    library today
    is slf4j –
    used by 30.7%
    of the 10,000

    projects(Tweet this)

    Spring.While Spring
    may be
    perceived by
    some as
    a more
    mature and
    less “hip”framework,
    it still
    sees tremendous
    usage,placing 15
    libraries in
    the top 100.
    Since Spring
    is an
    umbrella framework, it’
    s interesting
    to see
    which of
    its components
    are being
    used the
    most.Spring-
    test is
    the most
    used part
    of the

    framework(after the core library) with 376 entries.It’
    s followed
    by web-mvc for
    designing robust
    web applications
    with 277
    entries.After web
    functionality,
    we see
    web-
    orm with 218 entries,
    highlighting Spring’
    s key
    use case for
    building a
    DB backed
    Java web
    application.
            TDD.Right there
    with Spring
    at the
    top is
    JUnit with 3,068
    entries.This really
    shows the
    profound effect
    that Test
    Driven Development
    has had
    on the
    Java landscape.
    It seems
    that if you’
    re a
    Java developer
    posting your
    code,
    unit tests
    today are
    an absolute
    requirement.It’
    s also
    worthwhile noting
    that while
    JUnit is
    not alone
    in this

    space(TestNG, the 2 nd most popular testing framework, has 331 entries) it is by far the most dominant.
            [
    adrotate group =”11″]
    Mockito,
    a popular
    framework for
    mock based
    testing,
    has also
    gained wide
    appeal with 413 entries.EasyMock,
    another mocking
    framework,comes 2
    nd in this
    category with 231
    project entries.

    Google’
    s Guava
    framework is
    becoming mainstream – 4.8%of 10,000
    Java GitHub
    projects are

    using it(Tweet this)

    Apache Commons.
    Having looked
    at Spring, it’
    s important
    we don’
    t neglect
    Apache Commons, one
    of the
    most fundamental
    set of
    libraries within
    the language.Commons-
    io and
    Commons-
    lang are
    right there
    in the
    top 10 with 519 and 504
    entries respectively, showing
    their strong
    prevalence.
            As a
    whole Apache
    Commons have 13
    libraries in
    the top 100.Google’
    s Guava
    framework,
    which itself
    provides language

    utils(some similar to those found in Commons) is also doing very well with 483 entries,
    marking it
    as another
    key Java
    building block.
            04(1)
    Sql &
    NoSql.With NoSql
    and Big
    data being
    all the
    buzz these
    last couple

    of years(some for good reasons),it’
    s worthwhile
    looking at
    the actual
    usage numbers for
    both relational
    and NoSql
    technologies.The most
    popular Sql
    DB out
    there is
    MySql with 225
    entries.Hibernate ORM, while
    not a
    DB in
    itself,
    is also
    fairly popular
    with 181
    entries.This is
    one area
    that we
    need to
    keep in
    mind that
    as GH
    is an
    open source
    repository,
    we might
    see a
    somewhat stronger
    bias towards
    commercial DBs
    such as
    Oracle’
    s in
    a closed
    source dataset.

    Justifying the
    buzz:
    Hadoop is
    more popular
    in Java
    GitHub projects
    than Postgre

    SQL(Tweet this)

    Hadoop is
    also doing
    very well
    with 168 entries,
    showing that
    the buzz
    is justified
    when looking
    at its
    actual usage
    data.To put
    in perspective, it
    has more
    entries than

    Postgre SQL(with 121 entries),one of the most mature relational open source DBs out there.
    ElasticSearch,
    another Big
    data technology, is
    also on
    the board
    with 110
    project entries.It’
    s surprising
    to note
    that sqlite, which
    has 1,085
    entries in
    Ruby,isn’
    t in
    the Java
    top 100.
    Android.For mobile
    developers on
    GH we
    see 228
    project entries
    consuming Android
    via Maven.While this
    can signify
    that not
    a lot
    of mobile
    projects are
    placed on
    GH,it’
    s still
    a strong
    indicator that
    Java remains
    a very
    strong server
    side language.
    Surprised by
    some of
    the results?
    We know
    we were
    with some
    of them.
    Take a
    look at
    the full
    list of
    the top 100
    Java libraries
    on GitHub
    below,
    and let
    us know
    what you
    think in
    the comments
    section.We’
    d love
    to hear
    your thoughts
    and questions.

    main2(1)

    We Analyzed 30,000
    GitHub Projects –
    Here Are
    The Top 100
    Libraries in
    Java,
    JS and
    Ruby –
    read more


    Ophir Primat
    As VP
    Marketing,
    Ophir is
    in charge
    of driving
    OverOps' marketing strategies, demand generation, brand recognition and communications. Previously, Ophir was a financial journalist and editor-in-chief at Forbes Magazine. Considers dessert a full meal.

    developers
            Github
    Java
    Further Reading

    Featured Post
    Achieving Observability:
    How to
    Address the
    Unknown Unknowns
    in Your
    Application
    Get it
    Now

    Next Article

    We Analyzed 30,000
    GitHub Projects -
    Here Are
    The Top 100
    Libraries in
    Java,
    JS and
    Ruby
6
    min read
    Move Fast.
    Fix Faster.
    Prevent Rapid
    Code Changes
    From Impacting
    Customers.Identify and
    Resolve Your
    Most Critical
    Issues in
    Minutes.
            Learn More

    Developers:
    OverOps tells
    you when new
    code breaks
    in production –
    Learn more


    As Java
    developers working
    with a
    language that’
    s both
    mature yet
    highly evolving, we’
    re faced
    with a
    constant dilemma
    whenever we
    write new code –
    go with
    the hot new
    technology that
    everyone is
    talking about, or
    stick with
    a tried-and-true library?

    Since a
    very large
    part of
    Java applications
    are commercial
    in nature, it
    can sometimes
    be hard
    to separate
    the buzz
    around a new
    framework with
    the number
    of projects
    actually putting
    it to
    use.This is
    important,
    as the
    community of
    users and
    contributors around
    a framework
    is one
    of the
    strongest factors
    in determining
    its continuous
    success and
    development.

            We decided
    to use
    a data
    based approach
    to get
    more insight
    into this,
    by analyzing
    which Java
    projects developers
    are actually
    using on
    the world’
    s largest
    open repository for
    Java projects –
    GitHub.

            In our
    previous post
    we presented
    the main
    results of
    our GitHub
    research project
    and the
    top 100 libraries for JavaScript,
    Ruby and
    Java.Now let’
    s dive
    into the
    data,
    analyzing Java
    in particular.

    The Approach
    To generate
    our dataset
    we queried 10,000
    Java projects, with
    a bias
    towards the
    ones most
    favorited by
    the community, as
    a strong
    qualifying indicator
    towards their
    relative importance.
    We used
    the pom.xml,
    which is
    used by
    the vast
    majority of
    Java projects
    on GH, to
    define dependencies.
    We then
    analyzed and
    grouped those
    into categories.
    The results
    were really
    interesting.

            The Results
    The full
    list –Top 100 libraries for JavaScript,
    Ruby and
    Java
01
    Logging.The most
    popular Java
    library is
    slf4j –
    the logging
    facade framework, with 3,068
    entries.It seems
    that Java
    GH developers
    have fully
    embraced a
    decoupled approach
    towards their
    logging engine, and
    have standardized
    on slf4j
    to do
    so.
            Since slf4j
    isn’
    t a
    logging engine
    by itself, it’
    s also
    useful to
    see the
    top logging
    engines being
    used.It looks
    like the “winner”
    here is
    log4j – 891
    projects are
    using it.
    Next in
    line is
    Logback,with 340
    projects.While very
    respectable,this
    number still
    represents less
    than half
    of the
    projects using
    log4j.sfl4j’
    s simple
    logging implementation
    comes in
    third at 174
    projects.

            The most
    popular Java
    library today
    is slf4j –
    used by 30.7%
    of the 10,000

    projects(Tweet this)

    Spring.While Spring
    may be
    perceived by
    some as
    a more
    mature and
    less “hip”framework,
    it still
    sees tremendous
    usage,placing 15
    libraries in
    the top 100.
    Since Spring
    is an
    umbrella framework, it’
    s interesting
    to see
    which of
    its components
    are being
    used the
    most.Spring-
    test is
    the most
    used part
    of the

    framework(after the core library) with 376 entries.It’
    s followed
    by web-mvc for
    designing robust
    web applications
    with 277
    entries.After web
    functionality,
    we see
    web-
    orm with 218 entries,
    highlighting Spring’
    s key
    use case for
    building a
    DB backed
    Java web
    application.
            TDD.Right there
    with Spring
    at the
    top is
    JUnit with 3,068
    entries.This really
    shows the
    profound effect
    that Test
    Driven Development
    has had
    on the
    Java landscape.
    It seems
    that if you’
    re a
    Java developer
    posting your
    code,
    unit tests
    today are
    an absolute
    requirement.It’
    s also
    worthwhile noting
    that while
    JUnit is
    not alone
    in this

    space(TestNG, the 2 nd most popular testing framework, has 331 entries) it is by far the most dominant.
            [
    adrotate group =”11″]
    Mockito,
    a popular
    framework for
    mock based
    testing,
    has also
    gained wide
    appeal with 413 entries.EasyMock,
    another mocking
    framework,comes 2
    nd in this
    category with 231
    project entries.

    Google’
    s Guava
    framework is
    becoming mainstream – 4.8%of 10,000
    Java GitHub
    projects are

    using it(Tweet this)

    Apache Commons.
    Having looked
    at Spring, it’
    s important
    we don’
    t neglect
    Apache Commons, one
    of the
    most fundamental
    set of
    libraries within
    the language.Commons-
    io and
    Commons-
    lang are
    right there
    in the
    top 10 with 519 and 504
    entries respectively, showing
    their strong
    prevalence.
            As a
    whole Apache
    Commons have 13
    libraries in
    the top 100.Google’
    s Guava
    framework,
    which itself
    provides language

    utils(some similar to those found in Commons) is also doing very well with 483 entries,
    marking it
    as another
    key Java
    building block.
            04(1)
    Sql &
    NoSql.With NoSql
    and Big
    data being
    all the
    buzz these
    last couple

    of years(some for good reasons),it’
    s worthwhile
    looking at
    the actual
    usage numbers for
    both relational
    and NoSql
    technologies.The most
    popular Sql
    DB out
    there is
    MySql with 225
    entries.Hibernate ORM, while
    not a
    DB in
    itself,
    is also
    fairly popular
    with 181
    entries.This is
    one area
    that we
    need to
    keep in
    mind that
    as GH
    is an
    open source
    repository,
    we might
    see a
    somewhat stronger
    bias towards
    commercial DBs
    such as
    Oracle’
    s in
    a closed
    source dataset.

    Justifying the
    buzz:
    Hadoop is
    more popular
    in Java
    GitHub projects
    than Postgre

    SQL(Tweet this)

    Hadoop is
    also doing
    very well
    with 168 entries,
    showing that
    the buzz
    is justified
    when looking
    at its
    actual usage
    data.To put
    in perspective, it
    has more
    entries than

    Postgre SQL(with 121 entries),one of the most mature relational open source DBs out there.
    ElasticSearch,
    another Big
    data technology, is
    also on
    the board
    with 110
    project entries.It’
    s surprising
    to note
    that sqlite, which
    has 1,085
    entries in
    Ruby,isn’
    t in
    the Java
    top 100.
    Android.For mobile
    developers on
    GH we
    project entries
    consuming Android
    via Maven.While this
    can signify
    that not
    a lot
    of mobile
    projects are
    placed on
    GH,it’
    s still
    a strong
    indicator that
    Java remains
    a very
    strong server
    side language.
    Surprised by
    some of
    the results?
    We know
    we were
    with some
    of them.
    Take a
    look at
    the full
    list of
    the top 100
    Java libraries
    on GitHub
    below,
    and let
    us know
    what you
    think in
    the comments
    section.We’
    d love
    to hear
    your thoughts
    and questions.

    main2(1)

    We Analyzed 30,000
    GitHub Projects –
    Here Are
    The Top 100
    Libraries in
    Java,
    JS and
    Ruby –
    read more


    Ophir Primat
    As VP
    Marketing,
    Ophir is
    in charge
    of driving
    OverOps' marketing strategies, demand generation, brand recognition and communications. Previously, Ophir was a financial journalist and editor-in-chief at Forbes Magazine. Considers dessert a full meal.

    developers
            Github
    Java
    Further Reading

    Featured Post
    Achieving Observability:
    How to
    Address the
    Unknown Unknowns
    in Your
    Application
    Get it
    Now

    Next Article

    We Analyzed 30,000
    GitHub Projects -
    Here Are
    The Top 100
    Libraries in
    Java,
    JS and
    Ruby
6
    min read
    Move Fast.
    Fix Faster.
    Prevent Rapid
    Code Changes
    From Impacting
    Customers.Identify and
    Resolve Your
    Most Critical
    Issues in
    Minutes.
            Learn More

    Developers:
    OverOps tells
    you when new
    code breaks
    in production –
    Learn more


    As Java
    developers working
    with a
    language that’
    s both
    mature yet
    highly evolving, we’
    re faced
    with a
    constant dilemma
    whenever we
    write new code –
    go with
    the hot new
    technology that
    everyone is
    talking about, or
    stick with
    a tried-and-true library?

    Since a
    very large
    part of
    Java applications
    are commercial
    in nature, it
    can sometimes
    be hard
    to separate
    the buzz
    around a new
    framework with
    the number
    of projects
    actually putting
    it to
    use.This is
    important,
    as the
    community of
    users and
    contributors around
    a framework
    is one
    of the
    strongest factors
    in determining
    its continuous
    success and
    development.

            We decided
    to use
    a data
    based approach
    to get
    more insight
    into this,
    by analyzing
    which Java
    projects developers
    are actually
    using on
    the world’
    s largest
    open repository for
    Java projects –
    GitHub.

            In our
    previous post
    we presented
    the main
    results of
    our GitHub
    research project
    and the
    top 100 libraries for JavaScript,
    Ruby and
    Java.Now let’
    s dive
    into the
    data,
    analyzing Java
    in particular.

    The Approach
    To generate
    our dataset
    we queried 10,000
    Java projects, with
    a bias
    towards the
    ones most
    favorited by
    the community, as
    a strong
    qualifying indicator
    towards their
    relative importance.
    We used
    the pom.xml,
    which is
    used by
    the vast
    majority of
    Java projects
    on GH, to
    define dependencies.
    We then
    analyzed and
    grouped those
    into categories.
    The results
    were really
    interesting.

            The Results
    The full
    list –Top 100 libraries for JavaScript,
    Ruby and
    Java
01
    Logging.The most
    popular Java
    library is
    slf4j –
    the logging
    facade framework, with 3,068
    entries.It seems
    that Java
    GH developers
    have fully
    embraced a
    decoupled approach
    towards their
    logging engine, and
    have standardized
    on slf4j
    to do
    so.
            Since slf4j
    isn’
    t a
    logging engine
    by itself, it’
    s also
    useful to
    see the
    top logging
    engines being
    used.It looks
    like the “winner”
    here is
    log4j – 891
    projects are
    using it.
    Next in
    line is
    Logback,with 340
    projects.While very
    respectable,this
    number still
    represents less
    than half
    of the
    projects using
    log4j.sfl4j’
    s simple
    logging implementation
    comes in
    third at 174
    projects.

            The most
    popular Java
    library today
    is slf4j –
    used by 30.7%
    of the 10,000

    projects(Tweet this)

    Spring.While Spring
    may be
    perceived by
    some as
    a more
    mature and
    less “hip”framework,
    it still
    sees tremendous
    usage,placing 15
    libraries in
    the top 100.
    Since Spring
    is an
    umbrella framework, it’
    s interesting
    to see
    which of
    its components
    are being
    used the
    most.Spring-
    test is
    the most
    used part
    of the

    framework(after the core library) with 376 entries.It’
    s followed
    by web-mvc for
    designing robust
    web applications
    with 277
    entries.After web
    functionality,
    we see
    web-
    orm with 218 entries,
    highlighting Spring’
    s key
    use case for
    building a
    DB backed
    Java web
    application.
            TDD.Right there
    with Spring
    at the
    top is
    JUnit with 3,068
    entries.This really
    shows the
    profound effect
    that Test
    Driven Development
    has had
    on the
    Java landscape.
    It seems
    that if you’
    re a
    Java developer
    posting your
    code,
    unit tests
    today are
    an absolute
    requirement.It’
    s also
    worthwhile noting
    that while
    JUnit is
    not alone
    in this

    space(TestNG, the 2 nd most popular testing framework, has 331 entries) it is by far the most dominant.
            [
    adrotate group =”11″]
    Mockito,
    a popular
    framework for
    mock based
    testing,
    has also
    gained wide
    appeal with 413 entries.EasyMock,
    another mocking
    framework,comes 2
    nd in this
    category with 231
    project entries.

    Google’
    s Guava
    framework is
    becoming mainstream – 4.8%of 10,000
    Java GitHub
    projects are

    using it(Tweet this)

    Apache Commons.
    Having looked
    at Spring, it’
    s important
    we don’
    t neglect
    Apache Commons, one
    of the
    most fundamental
    set of
    libraries within
    the language.Commons-
    io and
    Commons-
    lang are
    right there
    in the
    top 10 with 519 and 504
    entries respectively, showing
    their strong
    prevalence.
            As a
    whole Apache
    Commons have 13
    libraries in
    the top 100.Google’
    s Guava
    framework,
    which itself
    provides language

    utils(some similar to those found in Commons) is also doing very well with 483 entries,
    marking it
    as another
    key Java
    building block.
            04(1)
    Sql &
    NoSql.With NoSql
    and Big
    data being
    all the
    buzz these
    last couple

    of years(some for good reasons),it’
    s worthwhile
    looking at
    the actual
    usage numbers for
    both relational
    and NoSql
    technologies.The most
    popular Sql
    DB out
    there is
    MySql with 225
    entries.Hibernate ORM, while
    not a
    DB in
    itself,
    is also
    fairly popular
    with 181
    entries.This is
    one area
    that we
    need to
    keep in
    mind that
    as GH
    is an
    open source
    repository,
    we might
    see a
    somewhat stronger
    bias towards
    commercial DBs
    such as
    Oracle’
    s in
    a closed
    source dataset.

    Justifying the
    buzz:
    Hadoop is
    more popular
    in Java
    GitHub projects
    than Postgre

    SQL(Tweet this)

    Hadoop is
    also doing
    very well
    with 168 entries,
    showing that
    the buzz
    is justified
    when looking
    at its
    actual usage
    data.To put
    in perspective, it
    has more
    entries than

    Postgre SQL(with 121 entries),one of the most mature relational open source DBs out there.
    ElasticSearch,
    another Big
    data technology, is
    also on
    the board
    with 110
    project entries.It’
    s surprising
    to note
    that sqlite, which
    has 1,085
    entries in
    Ruby,isn’
    t in
    the Java
    top 100.
    Android.For mobile
    developers on
    GH we
    see 228
    project entries
    consuming Android
    via Maven.While this
    can signify
    that not
    a lot
    of mobile
    projects are
    placed on
    GH,it’
    s still
    a strong
    indicator that
    Java remains
    a very
    strong server
    side language.
    Surprised by
    some of
    the results?
    We know
    we were
    with some
    of them.
    Take a
    look at
    the full
    list of
    the top 100
    Java libraries
    on GitHub
    below,
    and let
    us know
    what you
    think in
    the comments
    section.We’
    d love
    to hear
    your thoughts
    and questions.

    main2(1)

    We Analyzed 30,000
    GitHub Projects –
    Here Are
    The Top 100
    Libraries in
    Java,
    JS and
    Ruby –
    read more


    Ophir Primat
    As VP
    Marketing,
    Ophir is
    in charge
    of driving
    OverOps' marketing strategies, demand generation, brand recognition and communications. Previously, Ophir was a financial journalist and editor-in-chief at Forbes Magazine. Considers dessert a full meal.

    developers
            Github
    Java
    Further Reading

    Featured Post
    Achieving Observability:
    How to
    Address the
    Unknown Unknowns
    in Your
    Application
    Get it
    Now

    Next Article

    We Analyzed 30,000
    GitHub Projects -
    Here Are
    The Top 100
    Libraries in
    Java,
    JS and
    Ruby
6
    min read
    Move Fast.
    Fix Faster.
    Prevent Rapid
    Code Changes
    From Impacting
    Customers.Identify and
    Resolve Your
    Most Critical
    Issues in
    Minutes.
            Learn More

    Developers:
    OverOps tells
    you when new
    code breaks
    in production –
    Learn more


    As Java
    developers working
    with a
    language that’
    s both
    mature yet
    highly evolving, we’
    re faced
    with a
    constant dilemma
    whenever we
    write new code –
    go with
    the hot new
    technology that
    everyone is
    talking about, or
    stick with
    a tried-and-true library?

    Since a
    very large
    part of
    Java applications
    are commercial
    in nature, it
    can sometimes
    be hard
    to separate
    the buzz
    around a new
    framework with
    the number
    of projects
    actually putting
    it to
    use.This is
    important,
    as the
    community of
    users and
    contributors around
    a framework
    is one
    of the
    strongest factors
    in determining
    its continuous
    success and
    development.

            We decided
    to use
    a data
    based approach
    to get
    more insight
    into this,
    by analyzing
    which Java
    projects developers
    are actually
    using on
    the world’
    s largest
    open repository for
    Java projects –
    GitHub.

            In our
    previous post
    we presented
    the main
    results of
    our GitHub
    research project
    and the
    top 100 libraries for JavaScript,
    Ruby and
    Java.Now let’
    s dive
    into the
    data,
    analyzing Java
    in particular.

    The Approach
    To generate
    our dataset
    we queried 10,000
    Java projects, with
    a bias
    towards the
    ones most
    favorited by
    the community, as
    a strong
    qualifying indicator
    towards their
    relative importance.
    We used
    the pom.xml,
    which is
    used by
    the vast
    majority of
    Java projects
    on GH, to
    define dependencies.
    We then
    analyzed and
    grouped those
    into categories.
    The results
    were really
    interesting.

            The Results
    The full
    list –Top 100 libraries for JavaScript,
    Ruby and
    Java
01
    Logging.The most
    popular Java
    library is
    slf4j –
    the logging
    facade framework, with 3,068
    entries.It seems
    that Java
    GH developers
    have fully
    embraced a
    decoupled approach
    towards their
    logging engine, and
    have standardized
    on slf4j
    to do
    so.
            Since slf4j
    isn’
    t a
    logging engine
    by itself, it’
    s also
    useful to
    see the
    top logging
    engines being
    used.It looks
    like the “winner”
    here is
    log4j – 891
    projects are
    using it.
    Next in
    line is
    Logback,with 340
    projects.While very
    respectable,this
    number still
    represents less
    than half
    of the
    projects using
    log4j.sfl4j’
    s simple
    logging implementation
    comes in
    third at 174
    projects.

            The most
    popular Java
    library today
    is slf4j –
    used by 30.7%
    of the 10,000

    projects(Tweet this)

    Spring.While Spring
    may be
    perceived by
    some as
    a more
    mature and
    less “hip”framework,
    it still
    sees tremendous
    usage,placing 15
    libraries in
    the top 100.
    Since Spring
    is an
    umbrella framework, it’
    s interesting
    to see
    which of
    its components
    are being
    used the
    most.Spring-
    test is
    the most
    used part
    of the

    framework(after the core library) with 376 entries.It’
    s followed
    by web-mvc for
    designing robust
    web applications
    with 277
    entries.After web
    functionality,
    we see
    web-
    orm with 218 entries,
    highlighting Spring’
    s key
    use case for
    building a
    DB backed
    Java web
    application.
            TDD.Right there
    with Spring
    at the
    top is
    JUnit with 3,068
    entries.This really
    shows the
    profound effect
    that Test
    Driven Development
    has had
    on the
    Java landscape.
    It seems
    that if you’
    re a
    Java developer
    posting your
    code,
    unit tests
    today are
    an absolute
    requirement.It’
    s also
    worthwhile noting
    that while
    JUnit is
    not alone
    in this

    space(TestNG, the 2 nd most popular testing framework, has 331 entries) it is by far the most dominant.
            [
    adrotate group =”11″]
    Mockito,
    a popular
    framework for
    mock based
    testing,
    has also
    gained wide
    appeal with 413 entries.EasyMock,
    another mocking
    framework,comes 2
    nd in this
    category with 231
    project entries.

    Google’
    s Guava
    framework is
    becoming mainstream – 4.8%of 10,000
    Java GitHub
    projects are

    using it(Tweet this)

    Apache Commons.
    Having looked
    at Spring, it’
    s important
    we don’
    t neglect
    Apache Commons, one
    of the
    most fundamental
    set of
    libraries within
    the language.Commons-
    io and
    Commons-
    lang are
    right there
    in the
    top 10 with 519 and 504
    entries respectively, showing
    their strong
    prevalence.
            As a
    whole Apache
    Commons have 13
    libraries in
    the top 100.Google’
    s Guava
    framework,
    which itself
    provides language

    utils(some similar to those found in Commons) is also doing very well with 483 entries,
    marking it
    as another
    key Java
    building block.
            04(1)
    Sql &
    NoSql.With NoSql
    and Big
    data being
    all the
    buzz these
    last couple

    of years(some for good reasons),it’
    s worthwhile
    looking at
    the actual
    usage numbers for
    both relational
    and NoSql
    technologies.The most
    popular Sql
    DB out
    there is
    MySql with 225
    entries.Hibernate ORM, while
    not a
    DB in
    itself,
    is also
    fairly popular
    with 181
    entries.This is
    one area
    that we
    need to
    keep in
    mind that
    as GH
    is an
    open source
    repository,
    we might
    see a
    somewhat stronger
    bias towards
    commercial DBs
    such as
    Oracle’
    s in
    a closed
    source dataset.

    Justifying the
    buzz:
    Hadoop is
    more popular
    in Java
    GitHub projects
    than Postgre

    SQL(Tweet this)

    Hadoop is
    also doing
    very well
    with 168 entries,
    showing that
    the buzz
    is justified
    when looking
    at its
    actual usage
    data.To put
    in perspective, it
    has more
    entries than

    Postgre SQL(with 121 entries),one of the most mature relational open source DBs out there.
    ElasticSearch,
    another Big
    data technology, is
    also on
    the board
    with 110
    project entries.It’
    s surprising
    to note
    that sqlite, which
    has 1,085
    entries in
    Ruby,isn’
    t in
    the Java
    top 100.
    Android.For mobile
    developers on
    GH we
    see 228
    project entries
    consuming Android
    via Maven.While this
    can signify
    that not
    a lot
    of mobile
    projects are
    placed on
    GH,it’
    s still
    a strong
    indicator that
    Java remains
    a very
    strong server
    side language.
    Surprised by
    some of
    the results?
    We know
    we were
    with some
    of them.
    Take a
    look at
    the full
    list of
    the top 100
    Java libraries
    on GitHub
    below,
    and let
    us know
    what you
    think in
    the comments
    section.We’
    d love
    to hear
    your thoughts
    and questions.

    main2(1)

    We Analyzed 30,000
    GitHub Projects –
    Here Are
    The Top 100
    Libraries in
    Java,
    JS and
    Ruby –
    read more


    Ophir Primat
    As VP
    Marketing,
    Ophir is
    in charge
    of driving
    OverOps' marketing strategies, demand generation, brand recognition and communications. Previously, Ophir was a financial journalist and editor-in-chief at Forbes Magazine. Considers dessert a full meal.

    developers
            Github

    Developers:
    OverOps tells
    you when new
    code breaks
    in production –
    Learn more


    As Java
    developers working
    with a
    language that’
    s both
    mature yet
    highly evolving, we’
    re faced
    with a
    constant dilemma
    whenever we
    write new code –
    go with
    the hot new
    technology that
    everyone is
    talking about, or
    stick with
    a tried-and-true library?

    Since a
    very large
    part of
    Java applications
    are commercial
    in nature, it
    can sometimes
    be hard
    to separate
    the buzz
    around a new
    framework with
    the number
    of projects
    actually putting
    it to
    use.This is
    important,
    as the
    community of
    users and
    contributors around
    a framework
    is one
    of the
    strongest factors
    in determining
    its continuous
    success and
    development.

            We decided
    to use
    a data
    based approach
    to get
    more insight
    into this,
    by analyzing
    which Java
    projects developers
    are actually
    using on
    the world’
    s largest
    open repository for
    Java projects –
    GitHub.

            In our
    previous post
    we presented
    the main
    results of
    our GitHub
    research project
    and the
    top 100 libraries for JavaScript,
    Ruby and
    Java.Now let’
    s dive
    into the
    data,
    analyzing Java
    in particular.

    The Approach
    To generate
    our dataset
    we queried 10,000
    Java projects, with
    a bias
    towards the
    ones most
    favorited by
    the community, as
    a strong
    qualifying indicator
    towards their
    relative importance.
    We used
    the pom.xml,
    which is
    used by
    the vast
    majority of
    Java projects
    on GH, to
    define dependencies.
    We then
    analyzed and
    grouped those
    into categories.
    The results
    were really
    interesting.

            The Results
    The full
    list –Top 100 libraries for JavaScript,
    Ruby and
    Java
01
    Logging.The most
    popular Java
    library is
    slf4j –
    the logging
    facade framework, with 3,068
    entries.It seems
    that Java
    GH developers
    have fully
    embraced a
    decoupled approach
    towards their
    logging engine, and
    have standardized
    on slf4j
    to do
    so.
            Since slf4j
    isn’
    t a
    logging engine
    by itself, it’
    s also
    useful to
    see the
    top logging
    engines being
    used.It looks
    like the “winner”
    here is
    log4j – 891
    projects are
    using it.
    Next in
    line is
    Logback,with 340
    projects.While very
    respectable,this
    number still
    represents less
    than half
    of the
    projects using
    log4j.sfl4j’
    s simple
    logging implementation
    comes in
    third at 174
    projects.

            The most
    popular Java
    library today
    is slf4j –
    used by 30.7%
    of the 10,000

    projects(Tweet this)

    Spring.While Spring
    may be
    perceived by
    some as
    a more
    mature and
    less “hip”framework,
    it still
    sees tremendous
    usage,placing 15
    libraries in
    the top 100.
    Since Spring
    is an
    umbrella framework, it’
    s interesting
    to see
    which of
    its components
    are being
    used the
    most.Spring-
    test is
    the most
    used part
    of the

    framework(after the core library) with 376 entries.It’
    s followed
    by web-mvc for
    designing robust
    web applications
    with 277
    entries.After web
    functionality,
    we see
    web-
    orm with 218 entries,
    highlighting Spring’
    s key
    use case for
    building a
    DB backed
    Java web
    application.
            TDD.Right there
    with Spring
    at the
    top is
    JUnit with 3,068
    entries.This really
    shows the
    profound effect
    that Test
    Driven Development
    has had
    on the
    Java landscape.
    It seems
    that if you’
    re a
    Java developer
    posting your
    code,
    unit tests
    today are
    an absolute
    requirement.It’
    s also
    worthwhile noting
    that while
    JUnit is
    not alone
    in this

    space(TestNG, the 2 nd most popular testing framework, has 331 entries) it is by far the most dominant.
            [
    adrotate group =”11″]
    Mockito,
    a popular
    framework for
    mock based
    testing,
    has also
    gained wide
    appeal with 413 entries.EasyMock,
    another mocking
    framework,comes 2
    nd in this
    category with 231
    project entries.

    Google’
    s Guava
    framework is
    becoming mainstream – 4.8%of 10,000
    Java GitHub
    projects are

    using it(Tweet this)

    Apache Commons.
    Having looked
    at Spring, it’
    s important
    we don’
    t neglect
    Apache Commons, one
    of the
    most fundamental
    set of
    libraries within
    the language.Commons-
    io and
    Commons-
    lang are
    right there
    in the
    top 10 with 519 and 504
    entries respectively, showing
    their strong
    prevalence.
            As a
    whole Apache
    Commons have 13
    libraries in
    the top 100.Google’
    s Guava
    framework,
    which itself
    provides language

    utils(some similar to those found in Commons) is also doing very well with 483 entries,
    marking it
    as another
    key Java
    building block.
            04(1)
    Sql &
    NoSql.With NoSql
    and Big
    data being
    all the
    buzz these
    last couple

    of years(some for good reasons),it’
    s worthwhile
    looking at
    the actual
    usage numbers for
    both relational
    and NoSql
    technologies.The most
    popular Sql
    DB out
    there is
    MySql with 225
    entries.Hibernate ORM, while
    not a
    DB in
    itself,
    is also
    fairly popular
    with 181
    entries.This is
    one area
    that we
    need to
    keep in
    mind that
    as GH
    is an
    open source
    repository,
    we might
    see a
    somewhat stronger
    bias towards
    commercial DBs
    such as
    Oracle’
    s in
    a closed
    source dataset.

    Justifying the
    buzz:
    Hadoop is
    more popular
    in Java
    GitHub projects
    than Postgre

    SQL(Tweet this)

    Hadoop is
    also doing
    very well
    with 168 entries,
    showing that
    the buzz
    is justified
    when looking
    at its
    actual usage
    data.To put
    in perspective, it
    has more
    entries than

    Postgre SQL(with 121 entries),one of the most mature relational open source DBs out there.
    ElasticSearch,
    another Big
    data technology, is
    also on
    the board
    with 110
    project entries.It’
    s surprising
    to note
    that sqlite, which
    has 1,085
    entries in
    Ruby,isn’
    t in
    the Java
    top 100.
    Android.For mobile
    developers on
    GH we
    see 228
    project entries
    consuming Android
    via Maven.While this
    can signify
    that not
    a lot
    of mobile
    projects are
    placed on
    GH,it’
    s still
    a strong
    indicator that
    Java remains
    a very
    strong server
    side language.
    Surprised by
    some of
    the results?
    We know
    we were
    with some
    of them.
    Take a
    look at
    the full
    list of
    the top 100
    Java libraries
    on GitHub
    below,
    and let
    us know
    what you
    think in
    the comments
    section.We’
    d love
    to hear
    your thoughts
    and questions.

    main2(1)

    We Analyzed 30,000
    GitHub Projects –
    Here Are
    The Top 100
    Libraries in
    Java,
    JS and
    Ruby –
    read more


    Ophir Primat
    As VP
    Marketing,
    Ophir is
    in charge
    of driving
    OverOps' marketing strategies, demand generation, brand recognition and communications. Previously, Ophir was a financial journalist and editor-in-chief at Forbes Magazine. Considers dessert a full meal.

    developers
            Github
    Java
    Further Reading

    Featured Post
    Achieving Observability:
    How to
    Address the
    Unknown Unknowns
    in Your
    Application
    Get it
    Now

    Next Article

    We Analyzed 30,000
    GitHub Projects -
    Here Are
    The Top 100
    Libraries in
    Java,
    JS and
    Ruby
6
    min read
    Move Fast.
    Fix Faster.
    Prevent Rapid
    Code Changes
    From Impacting
    Customers.Identify and
    Resolve Your
    Most Critical
    Issues in
    Minutes.
            Learn More

    Developers:
    OverOps tells
    you when new
    code breaks
    in production –
    Learn more


    As Java
    developers working
    with a
    language that’
    s both
    mature yet
    highly evolving, we’
    re faced
    with a
    constant dilemma
    whenever we
    write new code –
    go with
    the hot new
    technology that
    everyone is
    talking about, or
    stick with
    a tried-and-true library?

    Since a
    very large
    part of
    Java applications
    are commercial
    in nature, it
    can sometimes
    be hard
    to separate
    the buzz
    around a new
    framework with
    the number
    of projects
    actually putting
    it to
    use.This is
    important,
    as the
    community of
    users and
    contributors around
    a framework
    is one
    of the
    strongest factors
    in determining
    its continuous
    success and
    development.

            We decided
    to use
    a data
    based approach
    to get
    more insight
    into this,
    by analyzing
    which Java
    projects developers
    are actually
    using on
    the world’
    s largest
    open repository for
    Java projects –
    GitHub.

            In our
    previous post
    we presented
    the main
    results of
    our GitHub
    research project
    and the
    top 100 libraries for JavaScript,
    Ruby and
    Java.Now let’
    s dive
    into the
    data,
    analyzing Java
    in particular.

    The Approach
    To generate
    our dataset
    we queried 10,000
    Java projects, with
    a bias
    towards the
    ones most
    favorited by
    the community, as
    a strong
    qualifying indicator
    towards their
    relative importance.
    We used
    the pom.xml,
    which is
    used by
    the vast
    majority of
    Java projects
    on GH, to
    define dependencies.
    We then
    analyzed and
    grouped those
    into categories.
    The results
    were really
    interesting.

            The Results
    The full
    list –Top 100 libraries for JavaScript,
    Ruby and
    Java
01
    Logging.The most
    popular Java
    library is
    slf4j –
    the logging
    facade framework, with 3,068
    entries.It seems
    that Java
    GH developers
    have fully
    embraced a
    decoupled approach
    towards their
    logging engine, and
    have standardized
    on slf4j
    to do
    so.
            Since slf4j
    isn’
    t a
    logging engine
    by itself, it’
    s also
    useful to
    see the
    top logging
    engines being
    used.It looks
    like the “winner”
    here is
    log4j – 891
    projects are
    using it.
    Next in
    line is
    Logback,with 340
    projects.While very
    respectable,this
    number still
    represents less
    than half
    of the
    projects using
    log4j.sfl4j’
    s simple
    logging implementation
    comes in
    third at 174
    projects.

            The most
    popular Java
    library today
    is slf4j –
    used by 30.7%
    of the 10,000

    projects(Tweet this)

    Spring.While Spring
    may be
    perceived by
    some as
    a more
    mature and
    less “hip”framework,
    it still
    sees tremendous
    usage,placing 15
    libraries in
    the top 100.
    Since Spring
    is an
    umbrella framework, it’
    s interesting
    to see
    which of
    its components
    are being
    used the
    most.Spring-
    test is
    the most
    used part
    of the

    framework(after the core library) with 376 entries.It’
    s followed
    by web-mvc for
    designing robust
    web applications
    with 277
    entries.After web
    functionality,
    we see
    web-
    orm with 218 entries,
    highlighting Spring’
    s key
    use case for
    building a
    DB backed
    Java web
    application.
            TDD.Right there
    with Spring
    at the
    top is
    JUnit with 3,068
    entries.This really
    shows the
    profound effect
    that Test
    Driven Development
    has had
    on the
    Java landscape.
    It seems
    that if you’
    re a
    Java developer
    posting your
    code,
    unit tests
    today are
    an absolute
    requirement.It’
    s also
    worthwhile noting
    that while
    JUnit is
    not alone
    in this

    space(TestNG, the 2 nd most popular testing framework, has 331 entries) it is by far the most dominant.
            [
    adrotate group =”11″]
    Mockito,
    a popular
    framework for
    mock based
    testing,
    has also
    gained wide
    appeal with 413 entries.EasyMock,
    another mocking
    framework,comes 2
    nd in this
    category with 231
    project entries.

    Google’
    s Guava
    framework is
    becoming mainstream – 4.8%of 10,000
    Java GitHub
    projects are

    using it(Tweet this)

    Apache Commons.
    Having looked
    at Spring, it’
    s important
    we don’
    t neglect
    Apache Commons, one
    of the
    most fundamental
    set of
    libraries within
    the language.Commons-
    io and
    Commons-
    lang are
    right there
    in the
    top 10 with 519 and 504
    entries respectively, showing
    their strong
    prevalence.
            As a
    whole Apache
    Commons have 13
    libraries in
    the top 100.Google’
    s Guava
    framework,
    which itself
    provides language

    utils(some similar to those found in Commons) is also doing very well with 483 entries,
    marking it
    as another
    key Java
    building block.
            04(1)
    Sql &
    NoSql.With NoSql
    and Big
    data being
    all the
    buzz these
    last couple

    of years(some for good reasons),it’
    s worthwhile
    looking at
    the actual
    usage numbers for
    both relational
    and NoSql
    technologies.The most
    popular Sql
    DB out
    there is
    MySql with 225
    entries.Hibernate ORM, while
    not a
    DB in
    itself,
    is also
    fairly popular
    with 181
    entries.This is
    one area
    that we
    need to
    keep in
    mind that
    as GH
    is an
    open source
    repository,
    we might
    see a
    somewhat stronger
    bias towards
    commercial DBs
    such as
    Oracle’
    s in
    a closed
    source dataset.

    Justifying the
    buzz:
    Hadoop is
    more popular
    in Java
    GitHub projects
    than Postgre

    SQL(Tweet this)

    Hadoop is
    also doing
    very well
    with 168 entries,
    showing that
    the buzz
    is justified
    when looking
    at its
    actual usage
    data.To put
    in perspective, it
    has more
    entries than

    Postgre SQL(with 121 entries),one of the most mature relational open source DBs out there.
    ElasticSearch,
    another Big
    data technology, is
    also on
    the board
    with 110
    project entries.It’
    s surprising
    to note
    that sqlite, which
    has 1,085
    entries in
    Ruby,isn’
    t in
    the Java
    top 100.
    Android.For mobile
    developers on
    GH we
    see 228
    project entries
    consuming Android
    via Maven.While this
    can signify
    that not
    a lot
    of mobile
    projects are
    placed on
    GH,it’
    s still
    a strong
    indicator that
    Java remains
    a very
    strong server
    side language.
    Surprised by
    some of
    the results?
    We know
    we were
    with some
    of them.
    Take a
    look at
    the full
    list of
    the top 100
    Java libraries
    on GitHub
    below,
    and let
    us know
    what you
    think in
    the comments
    section.We’
    d love
    to hear
    your thoughts
    and questions.

    main2(1)

    We Analyzed 30,000
    GitHub Projects –
    Here Are
    The Top 100
    Libraries in
    Java,
    JS and
    Ruby –
    read more


    Ophir Primat
    As VP
    Marketing,
    Ophir is
    in charge
    of driving
    OverOps' marketing strategies, demand generation, brand recognition and communications. Previously, Ophir was a financial journalist and editor-in-chief at Forbes Magazine. Considers dessert a full meal.

    developers
            Github
    Java
    Further Reading

    Featured Post
    Achieving Observability:
    How to
    Address the
    Unknown Unknowns
    in Your
    Application
    Get it
    Now

    Next Article

    We Analyzed 30,000
    GitHub Projects -
    Here Are
    The Top 100
    Libraries in
    Java,
    JS and
    Ruby
6
    min read
    Move Fast.
    Fix Faster.
    Prevent Rapid
    Code Changes
    From Impacting
    Customers.Identify and
    Resolve Your
    Most Critical
    Issues in
    Minutes.
            Learn More
    Java
    Further Reading

    Featured Post
    Achieving Observability:
    How to
    Address the
    Unknown Unknowns
    in Your
    Application
    Get it
    Now

    Next Article

    We Analyzed 30,000
    GitHub Projects -
    Here Are
    The Top 100
    Libraries in
    Java,
    JS and
    Ruby
6
    min read
    Move Fast.
    Fix Faster.
    Prevent Rapid
    Code Changes
    From Impacting
    Customers.Identify and
    Resolve Your
    Most Critical
    Issues in
    Minutes.
            Learn More


}
