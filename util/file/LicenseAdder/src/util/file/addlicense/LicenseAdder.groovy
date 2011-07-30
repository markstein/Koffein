package util.file.addlicense;

if(!args){
	println "usage: LicenseAdder dir licensefile"
	return;
}

list = args as List;

dir = new File(list.get(0));
license = new File(list.get(1)).text;

println("------license-------");
println(license);
println("--------------------");

iterateOverFilesInDir(dir);

def iterateOverFilesInDir(File file){
	if(file.isDirectory()){
		file.eachFile{addLicenseToFile(it);}
		file.eachDir{iterateOverFilesInDir(it);}
	}
	if(!file.isDirectory()){
		addLicenseToFile(file);
	}

}


def addLicenseToFile(File file){
	if(file.name.endsWith(".java")){
		println("file:" + file.name)
		oldContent = file.text;
		file.text = license + "\n\n" + oldContent;
	}
}


