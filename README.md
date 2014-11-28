TCP DBus Client
===============

This is an Android tcp client. It can send basic tcp information to a remote computer.

Features currently supported:

* play/pause
* previous/next
* volume control

See [tcpDbusServer](http://github.com/wichmannpas/tcpDbusServer) for a C++-written desktop application which can handle the tcp requests and send DBus commands.

Installation
------------

The master source code tree contains a precompiled apk file to install the Android app. You can install that on your phone, if you do not want to build the app by yourself. The app contains a preferences screen where you can manage the ip/domain and port of your tcp server.

What it sends
-------------

This app sends tcp strings to the host. They have the syntax *action:::target:::*, where *action* is the dbus action to send and *target* the dbus target application, or the action for *amixer*.

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
