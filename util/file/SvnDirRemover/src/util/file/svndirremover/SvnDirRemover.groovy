package util.file.svndirremover;

if(!args){
	println "usage: SvnDirRemover projectDir"
	return;
}

list = args as List;

dir = new File(list.get(0));

iterateOverFilesInDir(dir);

def iterateOverFilesInDir(File file){
	if(file.isDirectory()){
		if(file.name == ".svn"){
			removeSvnDir(file);
		} else {
			file.eachDir{iterateOverFilesInDir(it);}
		}
	}
}


def removeSvnDir(File file){
	println("remove dir:" + file.absolutePath)
	file.deleteDir();
}


