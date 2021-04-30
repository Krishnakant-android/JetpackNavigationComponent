package com.josh.navitationproject.module

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.math.BigDecimal
@Parcelize
data class Money (
    val amount: String,
    val name : String
) : Parcelable