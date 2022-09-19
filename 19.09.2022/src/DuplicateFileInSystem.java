//Problem Statement: Given a list paths of directory info, including the directory path,
// and all the files with contents in this directory, return all the duplicate files in the file
// system in terms of their paths. You may return the answer in any order.
//
//A group of duplicate files consists of at least two files that have the same content.
//
//A single directory info string in the input list has the following format:
//
//"root/d1/d2/.../dm f1.txt(f1_content) f2.txt(f2_content) ... fn.txt(fn_content)"
//It means there are n files (f1.txt, f2.txt ... fn.txt) with content (f1_content, f2_content ... fn_content)
// respectively in the directory "root/d1/d2/.../dm". Note that n >= 1 and m >= 0. If m = 0, it means the directory
// is just the root directory.
//
//The output is a list of groups of duplicate file paths. For each group, it contains all the file paths of
// the files that have the same content. A file path is a string that has the following format:
//
//"directory_path/file_name.txt"

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DuplicateFileInSystem {

    public static List<List<String>> findDuplicate(String[] paths) {

        HashMap<String, List<String>> hashMap = new HashMap<>();

        //loop through different paths
        for(String path : paths){

            String[] files = path.split(" ");

            String directory = files[0];

            //loop through files
            for(int i=1;i<files.length;i++){

                String[] file = files[i].split("[()]");

                //file name
                StringBuilder fileName = new StringBuilder(directory).append("/").append(file[0]);
                String fileContent = file[1];

                //add to hashmap containing content as keys and filenames into the value list
                if(hashMap.containsKey(fileContent)) {
                    hashMap.get(fileContent).add(fileName.toString());
                }
                else {
                    List<String> newList = List.of(fileName.toString());
                    hashMap.put(fileContent, new ArrayList<>(newList));
                }
            }
        }

        //add content with duplicate files
        List<List<String>> result = new ArrayList<>();

        for(List<String> files : hashMap.values()){
            if(files.size()>1){
                result.add(files);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] paths = {"root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)"};
        System.out.println(findDuplicate(paths));
    }
}
