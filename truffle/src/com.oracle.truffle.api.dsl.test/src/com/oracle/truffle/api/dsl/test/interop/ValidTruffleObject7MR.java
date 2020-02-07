/*
 * Copyright (c) 2016, 2018, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * The Universal Permissive License (UPL), Version 1.0
 *
 * Subject to the condition set forth below, permission is hereby granted to any
 * person obtaining a copy of this software, associated documentation and/or
 * data (collectively the "Software"), free of charge and under any and all
 * copyright rights in the Software, and any and all patent rights owned or
 * freely licensable by each licensor hereunder covering either (i) the
 * unmodified Software as contributed to or provided by such licensor, or (ii)
 * the Larger Works (as defined below), to deal in both
 *
 * (a) the Software, and
 *
 * (b) any piece of software and/or hardware listed in the lrgrwrks.txt file if
 * one is included with the Software each a "Larger Work" to which the Software
 * is contributed by such licensors),
 *
 * without restriction, including without limitation the rights to copy, create
 * derivative works of, display, perform, and distribute the Software and make,
 * use, sell, offer for sale, import, export, have made, and have sold the
 * Software and the Larger Work(s), and to sublicense the foregoing rights on
 * either these or other terms.
 *
 * This license is subject to the following condition:
 *
 * The above copyright notice and either this complete permission notice or at a
 * minimum a reference to the UPL must be included in all copies or substantial
 * portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.oracle.truffle.api.dsl.test.interop;

import com.oracle.truffle.api.dsl.test.ExpectError;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;

@SuppressWarnings({"unused", "deprecation"})
@com.oracle.truffle.api.interop.MessageResolution(receiverType = ValidTruffleObject7.class)
public class ValidTruffleObject7MR {
    @com.oracle.truffle.api.interop.Resolve(message = "EXECUTE")
    public abstract static class Execute2 extends Node {

        @ExpectError({"Wrong number of arguments. Expected signature: ([frame: VirtualFrame], receiverObject: TruffleObject, arguments: Object[])"})
        public Object access(String string, ValidTruffleObject0 object, Object[] args) {
            return true;
        }
    }

    @com.oracle.truffle.api.interop.Resolve(message = "INVOKE")
    public abstract static class Invoke2 extends Node {

        @ExpectError({"The 3 argument must be a java.lang.String- but is int"})
        public Object access(VirtualFrame frame, ValidTruffleObject0 object, int name, Object[] args) {
            return true;
        }
    }

    @com.oracle.truffle.api.interop.Resolve(message = "IS_BOXED")
    public abstract static class IsBoxed2 extends Node {

        @ExpectError({"Wrong number of arguments. Expected signature: ([frame: VirtualFrame], receiverObject: TruffleObject)"})
        public Object access(String string, ValidTruffleObject0 object) {
            return true;
        }
    }

    @ExpectError({"Class must be abstract"})
    @com.oracle.truffle.api.interop.Resolve(message = "READ")
    public static class ReadNode3 extends Node {
    }

    @ExpectError({"Class must be abstract"})
    @com.oracle.truffle.api.interop.Resolve(message = "READ")
    public final class ReadNodeNonStatic extends Node {
    }

    @com.oracle.truffle.api.interop.Resolve(message = "WRITE")
    public abstract static class WriteNode2 extends Node {

        @ExpectError({"Wrong number of arguments. Expected signature: ([frame: VirtualFrame], receiverObject: TruffleObject, identifier: String, value: Object)"})
        protected int access(VirtualFrame frame, Object receiver, Object name) {
            return 0;
        }
    }

}