/**
 * 查询所有
 * flag
 */
function findAll() {

    $.ajax({
        url: "findAll?currentPage=" + currentPage + "&pageSize=" + pageSize,
        type: "get",
        success: function (response) {

            let total = response.total;
            var str = "";
            for (var i = 0; i < response.data.length; i++) {
                str += `<tr>
                            <td>${response.data[i].custId}</td>
                            <td>${response.data[i].custName}</td>
                            <td>${response.data[i].custSourceName}</td>
                            <td>${response.data[i].custIndustryName}</td>
                            <td>${response.data[i].custLevelName}</td>
                            <td>${response.data[i].custPhone}</td>
                            <td>${response.data[i].custMobile}</td>
                            <td>
                                <a href='#' class='btn btn-primary btn-xs' data-toggle='modal'
                                   data-target='#customerEditDialog' onclick="findCustomerById(${response.data[i].custId})">修改</a>
                                <a href='#' class='btn btn-danger btn-xs' data-toggle='modal'
                                   data-target='#myModal'>删除</a>
                            </td>
                        </tr>`
            }

            $("tbody").html(str);

            if (currentPage == 0) {
                initPage(total);
            }

        }
    })
}

/**
 * 通过id查找信息
 */
function findCustomerById(id) {


    $.ajax({
        url: `findCustomerById/${id}`,
        type: "get",
        success: function (res) {

            $("#edit_customerName").val(res.custName)
            $("#edit_customerFrom").val(res.custSource)
            $("#edit_custIndustry").val(res.custIndustry)
            $("#edit_custLevel").val(res.custLevel)
            $("#edit_phone").val(res.custPhone)
            $("#edit_mobile").val(res.custMobile)
            $("#edit_cust_id").val(res.custId)

        }
    })


}


/**
 * 初始化分页插件
 * 总页数
 * 列表数据
 */

let currentPage = 0;//当前页
let pageSize = 5;//每一页的数量
function initPage(total) {
    $("#pagination").pagination(total,    //分布总数量，必须参数
        {
            callback: clickPageHandler,  //PageCallback() 为翻页调用次函数。
            prev_text: "« 上一页",
            next_text: "下一页 »",
            items_per_page: pageSize,
            num_edge_entries: 2,       //两侧首尾分页条目数
            num_display_entries: 10,    //连续分页主体部分分页条目数
            current_page: currentPage,   //当前页索引

        }
    );
}


findAll();

/**
 * 点击页吗时触发
 *
 * 第一点 我们知道了 页码从0开始
 * 第二点  只要初始化  默认进来就执行了第一页的回调函数
 */
function clickPageHandler(page) {

    currentPage = page + 1;
    findAll();


}


/**
 * 引入页面 加载下拉框信息
 */

function getSelectData(code) {

    $.ajax({
        url: `findByTypeCode?code=${code}`,
        type: "get",
        success: function (response) {
            console.log(response)

            var str = "";
            for (let i = 0; i < response.length; i++) {
                str += `<option value="${response[i].dictId}">${response[i].dictItemName}</option>`
            }
            if (code === "001") {
                $("#custIndustry").append(str)
                $("#edit_custIndustry").append(str)
            }
            if (code === "002") {

                $("#customerFrom").append(str)
                $("#edit_customerFrom").append(str)
            }

            if (code === "006") {
                $("#custLevel").append(str)
                $("#edit_custLevel").append(str)

            }
        }
    })

}

getSelectData("001");
getSelectData("002");
getSelectData("006");


/**
 * 原生阶段
 * @type {Element | null}
 */
var sendUpdate = document.querySelector("#sendUpdate");

sendUpdate.addEventListener("click", function () {
    //修改用户

    var serialize = $("#edit_customer_form").serialize();
    $.ajax({
        url: "update?" + serialize,
        type: "put",
        success: function (response) {
            findAll();
        }
    })

})





