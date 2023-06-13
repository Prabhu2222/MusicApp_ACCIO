public class Song {
    //imp->make variables private
    private String title;
    private double duration;
    //two constructors ->one default constructor and second is parameterized constructor

    public Song(){}
    public Song(String title,double duration){
        this.title=title;
        this.duration=duration;
    }
   //getters and setters
    public String getTitle(){
        return this.title;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public double getDuration(){
        return duration;
    }
    public void setDuration(double duration){
        this.duration =duration;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }


}
