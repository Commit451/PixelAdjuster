# PixelAdjustor
Changes the color of individual pixels in a Bitmap

[![Build Status](https://travis-ci.org/Commit451/PixelAdjuster.svg?branch=master)](https://travis-ci.org/Commit451/PixelAdjuster)

## Usage
See the sample app. Typical usage:

```java
PixelAdjustor.adjustColor(bitmap, Color.WHITE, Color.MAGENTA);
```

## #perfMatters
In the sample, we compare this library vs a native Java implementation. In some very basic testing with an image of 4096x2304, we are seeing the Java implementation take 1120 ms vs the native implementation taking 92ms.

## NDK
NDK docs and support are hard to come by. These references have helped a lot in developing the NDK parts of this lib

- https://github.com/kikoso/android-stackblur
- http://stackoverflow.com/questions/14398670/rotating-a-bitmap-using-jni-ndk
- https://github.com/googlesamples/android-ndk

License
--------

    Copyright 2018 Commit 451

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
