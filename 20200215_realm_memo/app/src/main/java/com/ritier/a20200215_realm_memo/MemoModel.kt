package com.ritier.a20200215_realm_memo

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class MemoModel(
    @PrimaryKey
    var id : Long = 0,
    var desc : String = ""
) : RealmObject()