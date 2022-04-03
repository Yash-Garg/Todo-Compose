package dev.yashg.todoist.utils

sealed class OrderType {
    object Ascending : OrderType()
    object Descending : OrderType()
}
