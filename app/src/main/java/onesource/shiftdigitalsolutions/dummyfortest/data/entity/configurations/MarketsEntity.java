package onesource.shiftdigitalsolutions.dummyfortest.data.entity.configurations;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class MarketsEntity {

    @PrimaryKey(autoGenerate = true)
    public long mId;

    @SerializedName("Id")
    @Expose
    Integer marketId;
    @SerializedName("MarketName")
    @Expose
    String marketName;

    public MarketsEntity(Integer marketId, String marketName) {
        this.marketId = marketId;
        this.marketName = marketName;
    }

    public Integer getMarketId() {
        return marketId;
    }

    public String getMarketName() {
        return marketName;
    }

    @NonNull
    @Override
    public String toString() {
        return "MarketsEntity{" +
                "marketId=" + marketId +
                ", marketName='" + marketName + '\'' +
                '}';
    }
}
