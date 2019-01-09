public class Playlist {

    public static class Song {
        private String name;
        private Song nextSong;

        public Song(String name) {
            this.name = name;
        }

        public void setNextSong(Song nextSong) {
            this.nextSong = nextSong;
        }

        public boolean isRepeatingPlaylist() {
            try {
            Song slowPointer = this; // Initially ptr1 is at starting location.
            Song fastPointer = this.nextSong; // Initially ptr2 is at starting location.

            while(fastPointer!=null && fastPointer.nextSong!=null){ // If ptr2 encounters NULL, it means there is no Loop in Linked list.
                slowPointer = slowPointer.nextSong; // ptr1 moving one node at at time
                fastPointer = fastPointer.nextSong.nextSong; // ptr2 moving two nodes at at time

                if(slowPointer.name==fastPointer.name) // if ptr1 and ptr2 meets, it means linked list contains loop.
                    return true;
            }
            return false;
            } catch (Exception e){
                return false;
            }

        }
    }

    public static void main(String[] args) {
        Song first = new Song("Hello");
        Song second = new Song("Eye of the tiger");

        first.setNextSong(second);
        second.setNextSong(first);

        System.out.println(first.isRepeatingPlaylist());
    }
}