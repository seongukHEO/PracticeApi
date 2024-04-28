package kr.co.seonguk.application.publicdatause

data class ApiResponse(
    val GGEXPSDLV: List<GGEXPSDLV>
)

data class GGEXPSDLV(
    val head: List<Head>,
    val row: List<Row>
)

data class Head(
    val RESULT: RESULT,
    val api_version: String,
    val list_total_count: Int
)

data class RESULT(
    val CODE: String,
    val MESSAGE: String
)

data class Row(
    val BIZREGNO: String,
    val INDUTYPE_NM: String,
    val REFINE_LOTNO_ADDR: String,
    val REFINE_ROADNM_ADDR: String,
    val REFINE_WGS84_LAT: String,
    val REFINE_WGS84_LOGT: String,
    val REFINE_ZIPNO: String,
    val SIGUN_NM: String,
    val STR_NM: String
)