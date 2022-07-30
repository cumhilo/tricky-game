package me.cxmilo.tricky;

import me.cxmilo.tricky.base.ExecutorBase;

/*
 * Numerical coordinates are used to represent the position of a table:
 *
 * [0|1|2]
 * [3|4|5]
 * [6|7|8]
 *
 * 2d coordinates are:
 * X       Y
 * [0|1|2] [0|0|0]
 * [0|1|2] [1|1|1]
 * [0|1|2] [2|2|2]
 *
 * [0 » x:0 y:0| 1 » x:1 y:0 | 2 » x:2 y:0]
 * [3 » x:0 y:1| 4 » x:1 y:1 | 5 » x:2 y:1]
 * [6 » x:0 y:2| 7 » x:1 y:2 | 8 » x:2 y:2]
 *
 * Table Size = 3
 * Num = 4
 * Y = 4 / 3 = 1.33... -> 1
 * X = 4 - (1 * 3) = 1
 *
 * Y = divide & floor: Number and TABLE SIZE
 * X = number - (Y * TABLE SIZE)
 */
public class TrickyGame extends ExecutorBase {
}

