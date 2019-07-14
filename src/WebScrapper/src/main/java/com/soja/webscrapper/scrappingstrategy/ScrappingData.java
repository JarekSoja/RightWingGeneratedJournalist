package com.soja.webscrapper.scrappingstrategy;

public class ScrappingData {

    private String baseAddress;
    private String tabClass;

    private ScrappingData() {
    }

    public String getBaseAddress() {
        return baseAddress;
    }

    public void setBaseAddress(String baseAddress) {
        this.baseAddress = baseAddress;
    }

    public String getTabClass() {
        return tabClass;
    }

    public void setTabClass(String tabClass) {
        this.tabClass = tabClass;
    }

    public static ScrappingData buildScrappingData(Source source) {

        switch (source) {
            case W_SIECI:
                return null;
            case TYGODNIK_SOLIDARNOSC:
                return null;
            case W_POLITYCE:
                return new ScrappingData.Builder("https://wpolityce.pl/polityka")
                        .tabClass("publication-link")
                        .build();
            default:
                return null;
        }
    }

    public enum Source {
        W_SIECI,
        TYGODNIK_SOLIDARNOSC,
        W_POLITYCE
    }

    public static class Builder {

        private String baseAddress;
        private String tabClass;

        public Builder(String baseAddress) {
            this.baseAddress = baseAddress;
        }

        public Builder tabClass(String tabClass) {
            this.tabClass = tabClass;
            return this;
        }

        public ScrappingData build() {
            ScrappingData data = new ScrappingData();
            data.baseAddress = this.baseAddress;
            data.tabClass = this.tabClass;
            return data;
        }
    }
}
