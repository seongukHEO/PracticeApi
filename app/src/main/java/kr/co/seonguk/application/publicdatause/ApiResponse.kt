package kr.co.seonguk.application.publicdatause

import com.squareup.moshi.Json

data class ApiResponse(
    @field:Json(name = "GGEXPSDLV")
    val GGEXPSDLV: List<GGEXPSDLV>
)

data class GGEXPSDLV(
    @field:Json(name = "head")
    val head: List<Head>,
    @field:Json(name = "row")
    val row: List<Row>,
)

data class Head(
    @field:Json(name = "result")
    val RESULT: RESULT,
    @field:Json(name = "api_version")
    val api_version: String,
    @field:Json(name = "list_total_count")
    val list_total_count: Int
)

data class RESULT(
    @field:Json(name = "CODE")
    val CODE: String,
    @field:Json(name = "MESSAGE")
    val MESSAGE: String
)

data class Row(
    @field:Json(name = "BIZREGNO")
    val BIZREGNO: String,
    @field:Json(name = "INDUTYPE_NM")
    val INDUTYPE_NM: String,
    @field:Json(name = "REFINE_LOTNO_ADDR")
    val REFINE_LOTNO_ADDR: String,
    @field:Json(name = "REFINE_ROADNM_ADDR")
    val REFINE_ROADNM_ADDR: String,
    @field:Json(name = "REFINE_WGS84_LAT")
    val REFINE_WGS84_LAT: String,
    @field:Json(name = "REFINE_WGS84_LOGT")
    val REFINE_WGS84_LOGT: String,
    @field:Json(name = "REFINE_ZIPNO")
    val REFINE_ZIPNO: String,
    @field:Json(name = "SIGUN_NM")
    val SIGUN_NM: String,
    @field:Json(name = "STR_NM")
    val STR_NM: String
)
