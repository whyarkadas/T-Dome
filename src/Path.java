import java.util.LinkedList;

public class Path {
    private String path= "";

    //private Stack<String> pathStack = new Stack<>();
    LinkedList<String> pathLinkedList = new LinkedList<>();

    public Path(String path) {
        //this.path = path;
        cd(path);
    }

    public String getPath() {

        int i =0;

        while(i<pathLinkedList.size()){

            path = path + "/" + pathLinkedList.get(i);
            i++;
        }
        return path;
    }

    public void cd(String newPath) {

        if(newPath.startsWith("/"))
            pathLinkedList.removeAll(pathLinkedList);

        String[] pathsArray = newPath.split("/");

        for (String path:pathsArray) {
            if (path.equals(""))
                continue;

            if (path.equals(".."))
                pathLinkedList.removeLast();
            else
                pathLinkedList.addLast(path);
        }
    }

    public static void main(String[] args) {
        Path path = new Path("/a/b/c/d");
        path.cd("../x");
        System.out.println(path.getPath());
    }
}