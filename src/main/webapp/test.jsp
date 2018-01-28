<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta charset="UTF-8">
    <title>测试页面</title>
    <link rel="stylesheet" type="text/css"	href="static/jquery-easyui-1.5.3/themes/gray/easyui.css">
    <link rel="stylesheet" type="text/css"	href="static/jquery-easyui-1.5.3/themes/icon.css">
</head>
<body>
<div id="panel" style="width:98%;padding:10px 10px;">
    <input id="select" style="width:20%;" value=""/>
</div>
</body>
<script type="text/javascript" src="static/jquery-easyui-1.5.3/jquery.min.js"></script>
<script type="text/javascript" src="static/jquery-easyui-1.5.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="static/jquery-easyui-1.5.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
    $(function(){
        AllCheckCombobox.initCombobox();
    });

    var AllCheckCombobox = (function (mod,selectId){

        var select = $("#"+selectId);
        /*
         * combobox获取data的函数，可以替换成动态后台ajax获取，此处只是静态数据模拟。
         */
        var getData = function (){
            var data =[{"text":"长沙","value":"111"},{"text":"常德","value":"222"}];
            data.unshift({"text":"全选/反选","value":""});
            return data;
        };

        /*
         * 扩展的核心函数之一，自己扩展combobox的onclick的函数，判断是否是全选/反选 选项，
         *  若果是 则选中全部的选项，否则，清空全部的选项
         */
        var onclick = function (record){
            var valueField = select.combobox("options").valueField;
            console.log(record);
            if(!record[valueField]){
                var data = select.combobox("getData");
                var values = select.combobox("getValues");
                var selectVaues = [];
                console.log(data);
                console.log(values);
                if((data.length - 1) != values.length){
                    data.reduce(function(prev, current, index, array){
                        selectVaues.push(current[valueField]);
                    },selectVaues);
                }else{
                    selectVaues.push(record[valueField]);
                }
                select.combobox('setValues', selectVaues);
            }
        };

        /*
         * combobox的初始化函数，还可以自己设定一些其他的选项，可以参看easyui的官网。
         */
        mod.initCombobox = function (){
            $('#'+selectId).combobox({
                valueField : 'value',
                textField : 'text',
                multiple : true,
                editable : false,
                panelHeight : 'auto',
                panelMaxHeight : 300,
                data : getData(),
                onClick:onclick,
                label : "城市 :",
                labelPosition : "before",
                labelAlign : 'right'
            });
        };
        return mod;
    })(window.AllCheckCombobox || {},'select');
</script>
</html>