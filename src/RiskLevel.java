public enum RiskLevel {
    GENERAL_SERVICES(0.52),
    HUMAN_TALENT(0.52),
    SECURITY(4.35),
    CEO(0.52),
    FLOOR(1.044);

    private Double riskLevel;

    RiskLevel(Double riskLevel){
        this.riskLevel = riskLevel;
    }

    public Double getRiskLevel() {
        return riskLevel;
    }
}
