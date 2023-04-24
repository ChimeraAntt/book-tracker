package special_types;

public class Series {
    private String seriesName;
    private int seriesNum;

    public Series(String seriesName, int seriesNum) {
        this.seriesName = seriesName;
        this.seriesNum = seriesNum;
    }
    public String getSeriesName() {
        return seriesName;
    }
    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }
    public int getSeriesNum() {
        return seriesNum;
    }
    public void setSeriesNum(int seriesNum) {
        this.seriesNum = seriesNum;
    }
}