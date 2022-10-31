
var rid=1;
//图片管理页面上点击删除按钮弹出删除框(providerList.html)
$(function () {
    $('.removeProvider').click(function () {
        $('.zhezhao').css('display', 'block');
        $('#removeProv').fadeIn();
    });
});

$(function () {
    $('#no').click(function () {
        $('.zhezhao').css('display', 'none');
        $('#removeProv').fadeOut();
    });
});


//视频管理页面上点击删除按钮弹出删除框(billList.html)
$(function () {
    $('.delete').click(function () {
        $('.zhezhao').css('display', 'block');
        $('#removeBi').fadeIn();
    });
});

$(function () {
    $('#no').click(function () {
        $('.zhezhao').css('display', 'none');
        $('#removeBi').fadeOut();
    });
});

//用户管理页面上点击删除按钮弹出删除框(userList.html)
$(function () {
    $('.removeUser').click(function () {
        $('.zhezhao').css('display', 'block');
        $('#removeUse').fadeIn();
    });
});

$(function () {
    $('#no').click(function () {
        $('.zhezhao').css('display', 'none');
        $('#removeUse').fadeOut();
    });
});

//角色管理页面上点击删除按钮弹出删除框(roleList.jsp)
function deleteRole(r) {
    this.rid=r;
    $('.zhezhao').css('display', 'block');
    $('#removeRe').fadeIn();
};

function deleteRoleSubmit() {
    document.getElementById("deleterole").action="deleterole?rid="+this.rid;
    document.getElementById("deleterole").submit();
    $('.zhezhao').css('display', 'none');
    $('#removeRe').fadeOut();
};

function detailsRole(r){
    this.rid=r;
    document.getElementById("deleterole").action="detailsrole?rid="+this.rid+"&type=details";
    document.getElementById("deleterole").submit();
}

function updatebeforeRole(r){
    this.rid=r;
    document.getElementById("deleterole").action="detailsrole?rid="+this.rid+"&type=update";
    document.getElementById("deleterole").submit();
}