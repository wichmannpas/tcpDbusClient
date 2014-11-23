TCP DBus Client
===============

This is an Android tcp client. It can send basic tcp information to a remote computer.

See [tcpDbusServer](http://github.com/wichmannpas/tcpDbusServer) for a C++-written desktop application which can handle the tcp requests and send DBus commands.

Installation
------------

This source code tree contains a precompiled apk file to install the Android app. But, until now, it is not yet possible to change the remote ip and port in the Android app: in the current version these data is hard coded. So you will need to download the source code, change the values in *src/com/wichmannpas/tcpDbusClient/MainActivity.java*. These are the only occurences that you will need to change.

Maybe I will implement the ability to modify these values in the app in the future.

What it sends
-------------

The app can send three strings through the tcp connection: *playPause*, *previous* and *next*. My script [tcpDbusServer](http://github.com/wichmannpas/tcpDbusServer) can handle these three commands.

License
-------

Copyright 2014 Pascal Wichmann

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
