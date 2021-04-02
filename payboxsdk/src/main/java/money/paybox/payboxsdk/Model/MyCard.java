package money.paybox.payboxsdk.Model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;
import money.paybox.payboxsdk.Utils.ParseUtils;


public class MyCard implements Parcelable {
    private String status;
    private String merchantId;
    private String cardId;
    private String recurringProfile;
    private String cardhash;
    private Date date;

    public MyCard(String status, String merchantId, String cardId, String recurringProfile, String cardhash, String date) {
        this.status = status;
        this.merchantId = merchantId;
        this.cardId = cardId;
        this.recurringProfile = recurringProfile;
        this.cardhash = cardhash;
        try {
            this.date = ParseUtils.simpleDateFormat.parse(date);
        } catch (Exception e){
            e.printStackTrace();
        }

    }
    public Date getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public String getCardId() {
        return cardId;
    }

    public String getRecurringProfile() {
        return recurringProfile;
    }

    public String getCardhash() {
        return cardhash;
    }


    protected MyCard(Parcel in) {
        status = in.readString();
        merchantId = in.readString();
        cardId = in.readString();
        recurringProfile = in.readString();
        cardhash = in.readString();
        long tmpDate = in.readLong();
        date = tmpDate != -1 ? new Date(tmpDate) : null;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(status);
        dest.writeString(merchantId);
        dest.writeString(cardId);
        dest.writeString(recurringProfile);
        dest.writeString(cardhash);
        dest.writeLong(date != null ? date.getTime() : -1L);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<MyCard> CREATOR = new Parcelable.Creator<MyCard>() {
        @Override
        public MyCard createFromParcel(Parcel in) {
            return new MyCard(in);
        }

        @Override
        public MyCard[] newArray(int size) {
            return new MyCard[size];
        }
    };
}
