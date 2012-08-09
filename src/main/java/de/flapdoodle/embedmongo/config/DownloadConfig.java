/**
 * Copyright (C) 2011
 *   Michael Mosmann <michael@mosmann.de>
 *   Martin Jöhren <m.joehren@googlemail.com>
 *
 * with contributions from
 * 	konstantin-ba@github,Archimedes Trajano (trajano@github)
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
package de.flapdoodle.embedmongo.config;

import de.flapdoodle.process.config.store.ArtifactStoreInUserHome;
import de.flapdoodle.process.config.store.IArtifactStoragePathNaming;
import de.flapdoodle.process.config.store.IDownloadConfig;
import de.flapdoodle.process.extract.ITempNaming;
import de.flapdoodle.process.extract.UUIDTempNaming;
import de.flapdoodle.process.io.progress.IProgressListener;
import de.flapdoodle.process.io.progress.StandardConsoleProgressListener;

public class DownloadConfig implements IDownloadConfig {

	private ITempNaming fileNaming = new UUIDTempNaming();
	
	private String downloadPath = "http://fastdl.mongodb.org/";

	private IProgressListener progressListener = new StandardConsoleProgressListener();
	private IArtifactStoragePathNaming artifactStorePath = new ArtifactStoreInUserHome();

	@Override
	public ITempNaming getFileNaming() {
		return fileNaming;
	}

	public void setFileNaming(ITempNaming fileNaming) {
		this.fileNaming = fileNaming;
	}


	public void setDownloadPath(String downloadPath) {
		this.downloadPath = downloadPath;
	}

	@Override
	public String getDownloadPath() {
		return downloadPath;
	}

	public void setProgressListener(IProgressListener progressListener) {
		this.progressListener = progressListener;
	}

	@Override
	public IProgressListener getProgressListener() {
		return progressListener;
	}

	public void setArtifactStorePathNaming(IArtifactStoragePathNaming value) {
		this.artifactStorePath = value;
	}

	@Override
	public IArtifactStoragePathNaming getArtifactStorePathNaming() {
		return artifactStorePath;
	}

}
