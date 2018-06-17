package t5;

public enum Disciplines {
    Programming(Integer.TYPE),
    Physics(Double.TYPE),
    Chemistry(Integer.TYPE),
    Biology(Double.TYPE);

    private Class estimateType;

    public Class getEstimateType() {
        return estimateType;
    }

    Disciplines(Class estimateType) {
        this.estimateType = estimateType;
    }
}
