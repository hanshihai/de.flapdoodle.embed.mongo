/**
 * Copyright (C) 2011
 *   Michael Mosmann <michael@mosmann.de>
 *   Martin Jöhren <m.joehren@googlemail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.flapdoodle.embedmongo.io;

import java.io.Reader;


public class Processors {

	private Processors() {
		throw new IllegalAccessError("singleton");
	}
	
	public static IBlockProcessor console() {
		return new BlockConsoleOutputProcessor();
	}
	
	public static IBlockProcessor named(String name, IBlockProcessor destination) {
		return new BlockNamedOutputProcessor(name, destination);
	}
	
	public static IBlockProcessor namedConsole(String name) {
		return named(name,console());
	}
	
	public static ReaderProcessor connect(Reader reader, IBlockProcessor processor) {
		return new ReaderProcessor(reader, processor);
	}
}