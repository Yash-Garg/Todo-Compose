package dev.yashg.todoist.utils

sealed class TaskOrder(val orderType: OrderType) {
    class Title(orderType: OrderType) : TaskOrder(orderType)
    class Date(orderType: OrderType) : TaskOrder(orderType)
}
