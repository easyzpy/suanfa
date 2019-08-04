package vo;

public class Drawing implements Cloneable{
    private String versionId;

    private String[] drawInfo = {"a", "b"};

    private String inquiryOrderItemId;

    private InquiryOrderItem inquiryOrderItem = new InquiryOrderItem("asfdafsdfasd");


    public Drawing() {

    }

    @Override
    public Drawing clone() throws CloneNotSupportedException {
        return (Drawing) super.clone();
    }

    public String getInquiryOrderItemId() {
        return inquiryOrderItemId;
    }

    public void setInquiryOrderItemId(String inquiryOrderItemId) {
        this.inquiryOrderItemId = inquiryOrderItemId;
    }

    public String getVersionId() {
        return versionId;
    }

    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }

    public String[] getDrawInfo() {
        return drawInfo;
    }

    public void setDrawInfo(String[] drawInfo) {
        this.drawInfo = drawInfo;
    }

    public Drawing(String versionId) {
        this.versionId = versionId;
    }
}
