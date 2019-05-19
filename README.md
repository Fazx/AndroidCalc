![](http://0blog.test.upcdn.net/20190518203530.png)

### 文件结构

文件结构作为Android而不是Project进行解析后如图很清晰：第一个(也就是main而非android或test路径下)的`/java/com.example.calc/`中为后端处理逻辑的Java类。`/res/layout/activity_main.xml`是主要的样式文件，资源文件可以放到`/drawable`、`/values`中进行引用。

### UI开发

Android布局主要有：

- RelativeLayout 相对布局(默认)
- LinearLayout 线性布局：`<LinearLayout></LinearLayout>`控件垂直和水平排列，父控件`layout_width="match_parent"`后按权重获得控件占比()
- FrameLayout 帧布局：按顺序重叠摆放
- TableLayout 表格布局：界面划分为多个单元格
- GridLayout 网格布局，4.0后引入，比表格布局更加好用
- AbsoluteLayout 绝对布局：指定xy坐标表示位置，由于屏幕尺寸和分辨率的不同非常低效，基本淘汰。

在这里我在线性布局中嵌套了网格布局，属性看这个图就一目了然(来自菜鸟教程)：

![](http://0blog.test.upcdn.net/20190519163647.png)

`GridLayout`的属性是这样的：
```
<GridLayout
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#191919"
    android:columnCount="4"
    android:rowCount="5">
```

结合按钮“零”的属性来解释：
```
<Button
    android:id="@+id/btn_0"
    android:layout_width="0dp"
    android:layout_rowWeight="1"
    android:layout_columnSpan="2"
    android:layout_columnWeight="1"
    android:background="@drawable/frame"
    android:text="零"
    android:textColor="#FFFFFF"
    android:textSize="30sp" />
```

网格被设置成了五行(row)四列(column)，button0占一行、横跨两列，`layout_width`设为0，背景资源从`drawable`中调用添加1dp边框后的版本。

### 后端实现

创建`MainActivity`继承自`AppCompatActivity`，并重写了`OnCreate()`方法，初始化生命周期：

![](http://0blog.test.upcdn.net/20190519172600.png)

`initViews()`初始化按键布局，`initButtons`使用`HashMap`建立了一个键值映射：

![](http://0blog.test.upcdn.net/20190519173527.png)

退格和等号的处理，这里的异常处理相当于利用了Java的异常，简洁有效：

![](http://0blog.test.upcdn.net/20190519173921.png)

运算逻辑处理写在DoCalc中，建立了一个伪的“元组”存储运算表达式，判断运算符or数字并进行强制类型转换，相比**运算栈**要简单但是只能支持双目运算：

![](http://0blog.test.upcdn.net/20190519174344.png)

**BigBang**取自 Smartisan OS 中的大爆炸功能，有些异曲同工之妙。之后就是进行拼接和计算操作，并处理除以零的异常，不再赘述。