package DSpractice.tree

class Heap(private var maxSize:Int) {
    var array = arrayOfNulls<Int>(maxSize)
    var currentSize=0
    constructor(maxSize: Int,initArray: Array<Int>):this(maxSize){
        var i=0
        for (element in initArray){
            array[i++]=element
        }
        currentSize=i
        adjust((currentSize-1)/2,0)
    }

    private fun adjust(i:Int,flag:Int){
        if (i==-1)
            return
        val left = i*2+1
        val right=i*2+2
        if (right<currentSize){
            val tag = if (array[left]!!>array[right]!!) left else right
            if (array[tag]!!>array[i]!!){
                swap(tag,i)
                adjust(tag,1)
            }
        }else if (left<currentSize){
            if (array[left]!!>array[i]!!){
                swap(left,i)
                adjust(left,1)
            }
        }
        if (flag==0){
            adjust(i-1,0)
        }
    }

    override fun toString(): String {
        val sb = StringBuilder()
        for (i in 0 until currentSize){
            sb.append(array[i]).append("  ")
        }
        return sb.toString()
    }
    private fun swap(i:Int,j:Int){
        val temp = array[i]
        array[i]=array[j]
        array[j]=temp
    }
    fun insert(i:Int){
        if (currentSize==maxSize){
            println("full!!!")
            return
        }
        var current=(currentSize-1)/2
        array[currentSize++]=i
        while (current>=0){
            val left = current*2+1
            val right=current*2+2
            var canBreak = true
            if (right<currentSize){
                val tag = if (array[left]!!>array[right]!!) left else right
                if (array[tag]!!>array[current]!!){
                    swap(tag,current)
                    canBreak=false
                    current=(current-1)/2
                }
            }else if (left<currentSize){
                if (array[left]!!>array[current]!!){
                    swap(left,current)
                    canBreak=false
                    current=(current-1)/2
                }
            }
            if(canBreak){
                return
            }
        }

    }
    fun delete(element:Int){
        val intPosition:Int= (0 until currentSize).firstOrNull { array[it]==element }
                ?: -1

        if (intPosition!=-1){
            swap(currentSize-1,intPosition)
            currentSize--
        }else{
            println("without this element!! ")
        }
        adjust(intPosition,1)
    }
}
fun main(args:Array<String>){
    val heap = Heap(100, arrayOf(20,12,35,15,10,80,30,17,2,1))
    println(heap)
    heap.insert(90)
    println(heap)
    heap.insert(22)
    println(heap)
    heap.delete(22)
    println(heap)
}