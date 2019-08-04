package vo;

public class InquiryOrderItem {
    private String inquiryOrderItemId;

    private String versionId;

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

    public InquiryOrderItem(String inquiryOrderItemId, String versionId) {
        this.inquiryOrderItemId = inquiryOrderItemId;
        this.versionId = versionId;
    }

    public InquiryOrderItem() {
    }

    public InquiryOrderItem(String inquiryOrderItemId) {
        this.inquiryOrderItemId = inquiryOrderItemId;
    }
}
