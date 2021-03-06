package com.sksamuel.elastic4s.http.search.queries.term

import com.sksamuel.elastic4s.json.{XContentBuilder, XContentFactory}
import com.sksamuel.elastic4s.searches.queries.RangeQueryDefinition

object RangeQueryBodyFn {

  def apply(range: RangeQueryDefinition): XContentBuilder = {

    val builder = XContentFactory.jsonBuilder().startObject("range").startObject(range.field)

    range.gte.foreach {
      case x: Long => builder.field("gte", x)
      case x: Double => builder.field("gte", x)
      case x: String => builder.field("gte", x)
    }

    range.lte.foreach {
      case x: Long => builder.field("lte", x)
      case x: Double => builder.field("lte", x)
      case x: String => builder.field("lte", x)
    }

    range.gt.foreach {
      case x: Long => builder.field("gt", x)
      case x: Double => builder.field("gt", x)
      case x: String => builder.field("gt", x)
    }

    range.lt.foreach {
      case x: Long => builder.field("lt", x)
      case x: Double => builder.field("lt", x)
      case x: String => builder.field("lt", x)
    }

    range.includeUpper.foreach(builder.field("include_upper", _))
    range.includeLower.foreach(builder.field("include_lower", _))

    range.format.foreach(builder.field("format", _))
    range.boost.foreach(builder.field("boost", _))
    range.timeZone.foreach(builder.field("time_zone", _))
    range.queryName.foreach(builder.field("_name", _))

    builder.endObject().endObject().endObject()
  }
}
