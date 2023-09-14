public class Contestant {

    private String name;

    private int score;

    public Contestant(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    public int compareTo(Contestant o) { // Check if could pass Contestant instead of Object

        if (this.score != o.getScore()) {
            return o.getScore() - this.score;
        }
        else {
            return this.name.compareTo(o.getName());
        }
    }
    
    public String toString() {
        String formated = this.name + ": " + this.score;
        return formated;
    }
}