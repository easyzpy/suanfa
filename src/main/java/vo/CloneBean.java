package vo;

import java.util.Date;

/**
 * 玩玩clone 和 copyProperty
 */
public class CloneBean {
    private String id;

    private Date birthday;

    private String[] arr;

    private InquiryOrderItem inquiryOrderItem;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String[] getArr() {
        return arr;
    }

    public void setArr(String[] arr) {
        this.arr = arr;
    }

    public InquiryOrderItem getInquiryOrderItem() {
        return inquiryOrderItem;
    }

    public void setInquiryOrderItem(InquiryOrderItem inquiryOrderItem) {
        this.inquiryOrderItem = inquiryOrderItem;
    }
}
