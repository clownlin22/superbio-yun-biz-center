(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[56],{jfgS:function(e,t,a){e.exports={searchForm:"antd-pro\\pages\\-spb-base\\-attachment\\-attachment-searchForm",tableListOperator:"antd-pro\\pages\\-spb-base\\-attachment\\-attachment-tableListOperator","ant-upload-select-picture-card":"antd-pro\\pages\\-spb-base\\-attachment\\-attachment-ant-upload-select-picture-card","ant-upload-text":"antd-pro\\pages\\-spb-base\\-attachment\\-attachment-ant-upload-text"}},xX2c:function(e,t,a){"use strict";var l=a("xK3H"),n=a("3rQ3");Object.defineProperty(t,"__esModule",{value:!0}),t.default=void 0,a("fhlT");var d=l(a("kXZy")),r=l(a("dnxz"));a("fThj");var u=l(a("cYEd"));a("khen");var o=l(a("3J+T"));a("hjCg");var i=l(a("Feml"));a("Ktq0");var c=l(a("fL5V")),f=l(a("8g53"));a("Jm7A");var s=l(a("F1Zk"));a("1pPU");var p=l(a("KjZ1"));a("Lzml");var m=l(a("vpm+"));a("/26P");var h=l(a("aYvq"));a("/MhY");var g=l(a("w0+5"));a("mKhK");var b=l(a("iW5v"));a("E2ON");var v=l(a("jjSt")),E=l(a("SeLb")),y=l(a("Sx57")),S=l(a("4zp0")),w=l(a("iVWQ")),z=l(a("lF+r")),M=l(a("PApH"));a("XFd2");var C=l(a("33fr"));a("Q3sr");var k,F,R,V,O,x,L,T,A,U=l(a("9NP+")),I=n(a("zLBQ")),P=l(a("CkN6")),j=l(a("zHco")),N=a("LneV"),K=l(a("jfgS")),D=l(a("rGht")),q=U.default.Item,H=C.default.confirm,J=(k=U.default.create(),k(F=function(e){function t(){var e,a;(0,y.default)(this,t);for(var l=arguments.length,n=new Array(l),d=0;d<l;d++)n[d]=arguments[d];return a=(0,w.default)(this,(e=(0,z.default)(t)).call.apply(e,[this].concat(n))),a.handleSearch=function(e){var t=a.props,l=t.form,n=t.handleSearch;l.validateFields(function(e,t){if(!e){var l=(0,E.default)({},t,{bizType:""===t.bizType?void 0:t.bizType,enabled:""===t.enabled?void 0:t.enabled});a.setState(function(){n(l)})}})},a.handleFormReset=function(){var e=a.props,t=e.form,l=e.handleFormReset;t.resetFields(),a.setState(function(){l()})},a}return(0,M.default)(t,e),(0,S.default)(t,[{key:"renderSearchForm",value:function(){var e=this.props,t=e.form.getFieldDecorator,a=(e.toggleSearchForm,e.bizType);return I.default.createElement(U.default,{layout:"inline",className:D.default.tableListForm},I.default.createElement(h.default,{gutter:{md:8,lg:24,xl:48}},I.default.createElement(b.default,{md:8,sm:24},I.default.createElement(q,{label:"\u4e1a\u52a1\u7c7b\u578b"},t("bizType")(I.default.createElement(v.default,{placeholder:"\u8bf7\u9009\u62e9\u4e1a\u52a1\u7c7b\u578b",allowClear:!0},a.map(function(e){return I.default.createElement(v.default.Option,{key:e.dataIndex},e.title)}))))),I.default.createElement(b.default,{md:8,sm:24},I.default.createElement(q,{label:"\u4e1a\u52a1\u4e3b\u952e"},t("bizId")(I.default.createElement(g.default,{placeholder:"\u8bf7\u8f93\u5165\u4e1a\u52a1\u4e3b\u952e"})))),I.default.createElement(b.default,{md:8,sm:24},I.default.createElement(q,{label:"\u542f\u7528\u72b6\u6001"},t("enabled")(I.default.createElement(v.default,{placeholder:"\u8bf7\u9009\u62e9",allowClear:!0},I.default.createElement(v.default.Option,{value:0},"\u7981\u7528"),I.default.createElement(v.default.Option,{value:1},"\u542f\u7528")))))),I.default.createElement(h.default,{gutter:{md:8,lg:24,xl:48}},I.default.createElement(b.default,{md:8,sm:24},I.default.createElement(q,{label:"\u6587\u4ef6\u540d\u79f0"},t("fileName")(I.default.createElement(g.default,{placeholder:"\u8bf7\u8f93\u5165\u6587\u4ef6\u540d\u79f0\uff08\u5305\u62ec\u6269\u5c55\u540d\uff09"})))),I.default.createElement(b.default,{md:16,sm:24},I.default.createElement("span",{className:D.default.submitButtons,style:{float:"right"}},I.default.createElement(m.default,{type:"primary",onClick:this.handleSearch},"\u67e5\u8be2"),I.default.createElement(m.default,{style:{marginLeft:8},onClick:this.handleFormReset},"\u91cd\u7f6e")))))}},{key:"render",value:function(){this.props.form;return I.default.createElement("div",null,this.renderSearchForm())}}]),t}(I.PureComponent))||F),Q=(R=U.default.create(),R(V=function(e){function t(e){var a;return(0,y.default)(this,t),a=(0,w.default)(this,(0,z.default)(t).call(this,e)),a.onOk=function(){var e=a.props,t=e.form,l=e.UploadModalOK,n=a.state.fileList;t.validateFields(function(e,d){if(!e){var r=(0,E.default)({},d);a.setState(function(){l(r,n[0])}),t.resetFields()}}),a.handleUpload()},a.onCancel=function(){var e=a.props.UploadModalCancel;a.setState(function(){e()})},a.handleUpload=function(){a.setState({fileList:[]})},a.state={fileList:[],uploading:!1},a}return(0,M.default)(t,e),(0,S.default)(t,[{key:"render",value:function(){var e=this,t=this.props,a=t.UploadModalVisable,l=t.form,n=t.bizType,d=(t.onRemove,this.state),r=(d.uploading,d.fileList),u={onRemove:function(t){e.setState(function(e){var a=e.fileList.indexOf(t),l=e.fileList.slice();return l.splice(a,1),{fileList:l}})},beforeUpload:function(t){return e.setState(function(e){return{fileList:[t]}}),!1},fileList:r};return I.default.createElement(C.default,{changeOnSelect:!0,title:"\u4e0a\u4f20\u6587\u4ef6",visible:a,onOk:this.onOk,onCancel:this.onCancel},I.default.createElement(U.default,{layout:"inline",className:K.default.searchForm},I.default.createElement(h.default,{gutter:{md:8,lg:24,xl:48}},I.default.createElement(b.default,{md:24,sm:24},I.default.createElement(q,{label:"\u4e1a\u52a1\u7c7b\u578b"},l.getFieldDecorator("bizType",{rules:[{required:!0,message:"\u8be5\u9879\u4e0d\u53ef\u4e3a\u7a7a"}]})(I.default.createElement(v.default,{placeholder:"\u8bf7\u9009\u62e9\u4e1a\u52a1\u7c7b\u578b",allowClear:!0},n.map(function(e){return I.default.createElement(v.default.Option,{key:e.dataIndex},e.title)})))))),I.default.createElement(h.default,{gutter:{md:8,lg:24,xl:48}},I.default.createElement(b.default,{md:24,sm:24},I.default.createElement(q,{label:"\u4e1a\u52a1\u4e3b\u952e"},l.getFieldDecorator("bizId",{rules:[{required:!0,message:"\u8be5\u9879\u4e0d\u53ef\u4e3a\u7a7a"},{pattern:new RegExp(/^[0-9]\d*$/,"g"),message:"\u8bf7\u8f93\u5165\u6570\u5b57"}]})(I.default.createElement(g.default,{placeholder:"\u8bf7\u8f93\u5165\u4e1a\u52a1\u4e3b\u952e"}))))),I.default.createElement(h.default,{gutter:{md:8,lg:24,xl:48}},I.default.createElement(b.default,{md:24,sm:24},I.default.createElement(q,{label:"\u63d0\u4ea4\u6587\u4ef6"},l.getFieldDecorator("upload",{rules:[{required:!0,message:"\u8be5\u9879\u4e0d\u53ef\u4e3a\u7a7a"}]})(I.default.createElement(s.default,u,I.default.createElement(m.default,null,I.default.createElement(p.default,{type:"upload"})," \u8bf7\u9009\u62e9\u6587\u4ef6"))))))))}}]),t}(I.PureComponent))||V),B=(O=U.default.create(),O(x=function(e){function t(){var e,a;(0,y.default)(this,t);for(var l=arguments.length,n=new Array(l),d=0;d<l;d++)n[d]=arguments[d];return a=(0,w.default)(this,(e=(0,z.default)(t)).call.apply(e,[this].concat(n))),a.onOk=function(){var e=a.props,t=e.updateOk,l=e.selectedRow,n=e.form;n.validateFields(function(e,d){if(!e){var r={id:l.id,bizType:d.bizType,bizId:d.bizId};a.setState(function(){t(r)}),n.resetFields()}})},a.onCancel=function(){var e=a.props.updateCancel;a.setState(function(){e()})},a}return(0,M.default)(t,e),(0,S.default)(t,[{key:"render",value:function(){var e=this.props,t=e.updateModalVisible,a=e.form,l=e.selectedRow,n=e.bizType;return I.default.createElement(C.default,{changeOnSelect:!0,title:"\u4fee\u6539\u6587\u4ef6\u8bb0\u5f55",visible:t,onOk:this.onOk,onCancel:this.onCancel},I.default.createElement(U.default,{layout:"inline",className:K.default.searchForm},I.default.createElement(h.default,{gutter:{md:8,lg:24,xl:48}},I.default.createElement(b.default,{md:24,sm:24},I.default.createElement(q,{label:"\u4e1a\u52a1\u7c7b\u578b"},a.getFieldDecorator("bizType",{initialValue:l.bizType,rules:[{required:!0,message:"\u8be5\u9879\u4e0d\u53ef\u4e3a\u7a7a"}]})(I.default.createElement(v.default,{placeholder:"\u8bf7\u9009\u62e9\u4e1a\u52a1\u7c7b\u578b",allowClear:!0},n.map(function(e){return I.default.createElement(v.default.Option,{key:e.dataIndex},e.title)})))))),I.default.createElement(h.default,{gutter:{md:8,lg:24,xl:48}},I.default.createElement(b.default,{md:24,sm:24},I.default.createElement(q,{label:"\u4e1a\u52a1\u4e3b\u952e"},a.getFieldDecorator("bizId",{initialValue:l.bizId,rules:[{required:!0,message:"\u8be5\u9879\u4e0d\u53ef\u4e3a\u7a7a"},{pattern:new RegExp(/^[0-9]\d*$/,"g"),message:"\u8bf7\u8f93\u5165\u6570\u5b57"}]})(I.default.createElement(g.default,{placeholder:"\u8bf7\u8f93\u5165\u4e1a\u52a1\u4e3b\u952e"})))))))}}]),t}(I.PureComponent))||x),X=(L=(0,N.connect)(function(e){var t=e.AttachmentModal,a=e.loading;return{AttachmentModal:t,loading:a.models.AttachmentModal}}),T=U.default.create(),L(A=T(A=function(e){function t(){var e,a;(0,y.default)(this,t);for(var l=arguments.length,n=new Array(l),d=0;d<l;d++)n[d]=arguments[d];return a=(0,w.default)(this,(e=(0,z.default)(t)).call.apply(e,[this].concat(n))),a.state={selectedRows:[],selectedRow:{},AttachmentList:[],formValues:[],pageSize:10,currentPage:1,UploadModalVisable:!1,updateModalVisible:!1,onRemove:!1},a.handleSearch=function(e){var t=a.props,l=t.dispatch,n=(t.form,a.state),d=n.pageSize,r=n.currentPage;a.setState({formValues:e}),l({type:"AttachmentModal/page",payload:(0,E.default)({},e,{pageSize:d,currentPage:r})})},a.handleFormReset=function(){var e=a.props,t=(e.form,e.dispatch);t({type:"AttachmentModal/page",payload:{pageSize:10,currentPage:1}}),a.setState({formValues:{}})},a.handleSelectRows=function(e){a.setState({selectedRows:e,selectedRow:e[0]})},a.handleStandardTableChange=function(e){var t=a.state.formValues,l=a.props.dispatch;l({type:"AttachmentModal/page",payload:(0,E.default)({},t,{pageSize:e.pageSize,currentPage:e.current})}),a.setState({pageSize:e.pageSize,currentPage:e.current})},a.UploadModalOK=function(e,t){var l=a.props.dispatch,n=a.state.formValues,d=new FormData,r=[e.bizId],u=[e.bizType];d.append("file",t),d.append("bizType",u),d.append("bizId",r),new Promise(function(e,t){l({type:"AttachmentModal/add",payload:{formData:d,resolve:e,reject:t}})}).then(function(e){null!=e&&a.handleSearch(n)}),a.setState({UploadModalVisable:!1,onRemove:!0})},a.UploadModalCancel=function(){a.setState({UploadModalVisable:!1})},a.UploadModalVisable=function(){a.setState({UploadModalVisable:!0})},a.remove=function(){var e=a.props.dispatch,t=a.state,l=t.selectedRows,n=t.formValues,d=(0,f.default)((0,f.default)(a)),r=l.map(function(e){return e.id.toString()});H({title:"\u786e\u5b9a\u8981\u5220\u9664\u6570\u636e\u5417?",onOk:function(){new Promise(function(t,a){e({type:"AttachmentModal/removeByIds",payload:{ids:r,resolve:t,reject:a}})}).then(function(e){d.handleSearch(n)}),d.setState({selectedRows:[]}),c.default.success("\u5220\u9664\u6210\u529f")},onCancel:function(){}})},a.showUpdateModal=function(e){a.setState({updateModalVisible:!0,selectedRow:e})},a.updateOk=function(e){var t=a.props.dispatch,l=a.state,n=l.formValues,d=l.AttachmentList,r=(0,E.default)({},e);d.push(r),new Promise(function(e,a){t({type:"AttachmentModal/update",payload:{AttachmentList:d,resolve:e,reject:a}})}).then(function(e){null!=e&&(c.default.success("\u4fee\u6539\u6210\u529f"),a.handleSearch(n))}),a.setState({updateModalVisible:!1})},a.updateCancel=function(){a.setState({updateModalVisible:!1})},a}return(0,M.default)(t,e),(0,S.default)(t,[{key:"componentDidMount",value:function(){var e=this.props.dispatch;this.state.formValues;e({type:"AttachmentModal/page",payload:{pageSize:10,currentPage:1}})}},{key:"onChange",value:function(e,t){var a=this,l=this.props.dispatch,n=this.state.AttachmentList,d={id:e.id,enabled:!1===t?0:1};n.push(d),new Promise(function(e,t){l({type:"AttachmentModal/update",payload:{AttachmentList:n,resolve:e,reject:t}}),a.setState({AttachmentList:[]})}).then(function(e){}),c.default.success(!1===t?"\u7981\u7528\u6210\u529f":"\u542f\u7528\u6210\u529f")}},{key:"render",value:function(){var e=this,t=this.props,a=t.AttachmentModal,l=a.data,n=a.bizType,c=t.loading,f=(t.dispatch,this.state),s=f.selectedRows,h=f.selectedRow,g=f.UploadModalVisable,b=f.updateModalVisible,v=f.onRemove,E={handleSearch:this.handleSearch,handleFormReset:this.handleFormReset},y={UploadModalOK:this.UploadModalOK,UploadModalCancel:this.UploadModalCancel},S={updateOk:this.updateOk,updateCancel:this.updateCancel},w=[{title:"\u4e1a\u52a1\u7c7b\u578b",dataIndex:"bizType",align:"center"},{title:"\u4e1a\u52a1\u4e3b\u952e",dataIndex:"bizId",align:"center"},{title:"\u6587\u4ef6\u540d",dataIndex:"fileName",align:"center"},{title:"\u6587\u4ef6\u5927\u5c0f",dataIndex:"fileSizeInHuman",align:"center"},{title:"Md5",dataIndex:"fileMd5",align:"center"},{title:"\u72b6\u6001",dataIndex:"enabled",align:"center",render:function(t,a){return I.default.createElement("div",null,I.default.createElement(i.default,{checkedChildren:"\u542f\u7528",unCheckedChildren:"\u7981\u7528",defaultChecked:!!a.enabled,onChange:function(t){return e.onChange(a,t)}}))}},{title:"\u64cd\u4f5c",key:"action",align:"center",width:"110px",render:function(t,a){return I.default.createElement(I.Fragment,null,I.default.createElement(o.default,{title:"\u4e0b\u8f7d"},I.default.createElement("a",{href:"/spbbase-attachment-web/api/attachment/{id}/download?id=".concat(a.id)},I.default.createElement(p.default,{type:"download"}))),I.default.createElement(u.default,{type:"vertical"}),I.default.createElement(o.default,{title:"\u4fee\u6539"},I.default.createElement("a",{href:"javascript:;",onClick:function(){return e.showUpdateModal(a)}},I.default.createElement(p.default,{type:"edit"}))))}}];return I.default.createElement(j.default,{title:"\u6587\u4ef6\u7ba1\u7406"},I.default.createElement(d.default,{bordered:!1},I.default.createElement(J,(0,r.default)({bizType:n},E)),I.default.createElement(Q,(0,r.default)({},y,{bizType:n,onRemove:v,UploadModalVisable:g})),h&&0!=h?I.default.createElement(B,(0,r.default)({},S,{bizType:n,updateModalVisible:b,selectedRow:h})):null,I.default.createElement("div",{className:D.default.tableList},I.default.createElement("div",{className:D.default.tableListOperator},I.default.createElement("span",null,I.default.createElement(m.default,{onClick:this.UploadModalVisable},"\u4e0a\u4f20"),I.default.createElement(m.default,{type:"danger",disabled:!s.length>0,onClick:this.remove},"\u5220\u9664")))),I.default.createElement(P.default,{rowKey:"id",selectedRows:s,loading:c,data:l,columns:w,onChange:this.handleStandardTableChange,onSelectRow:this.handleSelectRows})))}}]),t}(I.PureComponent))||A)||A),Y=X;t.default=Y}}]);