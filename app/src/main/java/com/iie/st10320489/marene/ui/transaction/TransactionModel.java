package com.iie.st10320489.marene.ui.transaction;

import android.os.Parcel;
import android.os.Parcelable;

public class TransactionModel implements Parcelable {
    private final Integer transactionIcon;
    private final String transactionName;
    private final Double transactionAmount;
    private final Boolean isExpense;
    private final String transactionMethod;
    private final String transactionDate;
    private final Integer transactionColor;
    private final String transactionCategory;

    // NEW FIELDS
    private final String transactionLocation;
    private final String transactionDescription;
    private final String transactionPhotoUri;

    public TransactionModel(Integer transactionIcon, String transactionName, Double transactionAmount,
                            Boolean isExpense, String transactionMethod, String transactionDate,
                            Integer transactionColor, String transactionCategory,
                            String transactionLocation, String transactionDescription,
                            String transactionPhotoUri) {
        this.transactionIcon = transactionIcon;
        this.transactionName = transactionName;
        this.transactionAmount = transactionAmount;
        this.isExpense = isExpense;
        this.transactionMethod = transactionMethod;
        this.transactionDate = transactionDate;
        this.transactionColor = transactionColor;
        this.transactionCategory = transactionCategory;
        this.transactionLocation = transactionLocation;
        this.transactionDescription = transactionDescription;
        this.transactionPhotoUri = transactionPhotoUri;
    }

    protected TransactionModel(Parcel in) {
        if (in.readByte() == 0) {
            transactionIcon = null;
        } else {
            transactionIcon = in.readInt();
        }
        transactionName = in.readString();
        if (in.readByte() == 0) {
            transactionAmount = null;
        } else {
            transactionAmount = in.readDouble();
        }
        byte tmpIsExpense = in.readByte();
        isExpense = tmpIsExpense == 1;
        transactionMethod = in.readString();
        transactionDate = in.readString();
        if (in.readByte() == 0) {
            transactionColor = null;
        } else {
            transactionColor = in.readInt();
        }
        transactionCategory = in.readString();

        // Read new fields
        transactionLocation = in.readString();
        transactionDescription = in.readString();
        transactionPhotoUri = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (transactionIcon == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(transactionIcon);
        }
        dest.writeString(transactionName);
        if (transactionAmount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(transactionAmount);
        }
        dest.writeByte((byte) (isExpense ? 1 : 0));
        dest.writeString(transactionMethod);
        dest.writeString(transactionDate);
        if (transactionColor == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(transactionColor);
        }
        dest.writeString(transactionCategory);

        // Write new fields
        dest.writeString(transactionLocation);
        dest.writeString(transactionDescription);
        dest.writeString(transactionPhotoUri);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TransactionModel> CREATOR = new Creator<TransactionModel>() {
        @Override
        public TransactionModel createFromParcel(Parcel in) {
            return new TransactionModel(in);
        }

        @Override
        public TransactionModel[] newArray(int size) {
            return new TransactionModel[size];
        }
    };

    public Integer getTransactionIcon() { return transactionIcon; }
    public String getTransactionName() { return transactionName; }
    public Double getTransactionAmount() { return transactionAmount; }
    public Boolean getIsExpense() { return isExpense; }
    public String getTransactionMethod() { return transactionMethod; }
    public String getTransactionDate() { return transactionDate; }
    public Integer getTransactionColor() { return transactionColor; }
    public String getTransactionCategory() { return transactionCategory; }

    // Getters for new fields
    public String getTransactionLocation() { return transactionLocation; }
    public String getTransactionDescription() { return transactionDescription; }
    public String getTransactionPhotoUri() { return transactionPhotoUri; }
}
