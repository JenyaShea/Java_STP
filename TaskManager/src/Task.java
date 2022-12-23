import java.time.LocalDate;


public class Task {

    private int id;
    private LocalDate crDate;
    private LocalDate endDate;
    private String title;
    private String description;
    private boolean completable;

    public Task(int id, String title, String description,LocalDate crDate, LocalDate endDate) {
        this.completable = false;
        this.title = title;
        this.description = description;
        this.crDate = crDate;
        this.endDate = endDate;
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public String getTitle(){
        return this.title;
    }
    public String getDescription(){
        return this.description;
    }
    public Boolean getCompetable(){
        return this.completable;
    }
    public LocalDate getCrDate(){
        return crDate;
    }
    public LocalDate getEndDate(){
        return endDate;
    }
}

