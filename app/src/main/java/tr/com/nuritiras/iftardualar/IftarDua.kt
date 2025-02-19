package tr.com.nuritiras.iftardualar

import android.os.Parcel
import android.os.Parcelable

class IftarDua(val ramazan: String?, val gun: String?, val resim: Int):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(ramazan)
        parcel.writeString(gun)
        parcel.writeInt(resim)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<IftarDua> {
        override fun createFromParcel(parcel: Parcel): IftarDua {
            return IftarDua(parcel)
        }

        override fun newArray(size: Int): Array<IftarDua?> {
            return arrayOfNulls(size)
        }
    }
}