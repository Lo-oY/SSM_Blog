function dataListLoadFilter(data) {
    console.log(data)
    if ($.isArray(data.item)) {
        data = {
            total: data.item.length,
            rows: data.item
        };
    } else {
        data = {
            total: data.length,
            rows: data
        }
    }
    return data;
}
