StateEnum.ON
[![CI](https://github.com/teverett/kspa/actions/workflows/main.yml/badge.svg)](https://github.com/teverett/kspa/actions/workflows/main.yml)

KSpa
=============

A Java library for using the [Arctic Spa's](https://www.arcticspas.ca/) API.  API details are [here](https://api.myarcticspa.com/docs/).

License
-------------

KSpa is licensed under the 2-Clause BSD license.

Maven Coordinates
-------------

```
<groupId>com.khubla.kspa</groupId>
<artifactId>kspa</artifactId>
<version>1.0.0</version>
<packaging>jar</packaging>
```

Usage
-------------

The class "com.khubla.kspa.Spa" is the entry point. Simply pass it an API key in the ctor and call the methods.  

```
Spa spa = new Spa("abc123");
Status status = spa.getStatus();
System.out.println("Temperature :"+status.getTemperature());
```

```
Spa spa = new Spa("abc123");
spa.setLights(StateEnum.ON);
spa.setBlower(2, StateEnum.ON);
```

