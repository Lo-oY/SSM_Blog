function dataListLoadFilter(data) {
    console.log(data)
    if ($.isArray(data.menuList)) {
        data = {
            total: data.menuList.length,
            rows: data.menuList
        };
    } else {
        data = {
            total: data.length,
            rows: data
        }
    }
    return data;
}
