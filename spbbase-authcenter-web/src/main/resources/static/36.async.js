(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[36],{"4Ofr":function(e,t,a){e.exports={themeColor:"antd-pro\\components\\-setting-drawer\\-theme-color-themeColor",title:"antd-pro\\components\\-setting-drawer\\-theme-color-title",colorBlock:"antd-pro\\components\\-setting-drawer\\-theme-color-colorBlock"}},"8TWP":function(e,t,a){"use strict";var n=a("3rQ3"),l=a("xK3H");Object.defineProperty(t,"__esModule",{value:!0}),t.default=void 0,a("Z2z2");var o=l(a("kI2X"));a("fjSA");var r=l(a("arrB"));a("1pPU");var i=l(a("KjZ1"));a("bQCI");var u=l(a("lMRA")),d=l(a("dnxz")),c=l(a("Sx57")),s=l(a("4zp0")),f=l(a("iVWQ")),p=l(a("lF+r")),m=l(a("PApH"));a("w4nt");var h=l(a("3oEu")),g=n(a("zLBQ")),v=l(a("h/XY")),y=l(a("iczh")),b=l(a("SlZz")),E=l(a("btmg")),M=h.default.TabPane,x=function(e){function t(){var e,a;(0,c.default)(this,t);for(var n=arguments.length,l=new Array(n),o=0;o<n;o++)l[o]=arguments[o];return a=(0,f.default)(this,(e=(0,p.default)(t)).call.apply(e,[this].concat(l))),a.onItemClick=function(e,t){var n=a.props.onItemClick,l=e.clickClose;n(e,t),l&&a.popover.click()},a.onClear=function(e){var t=a.props,n=t.onClear,l=t.clearClose;n(e),l&&a.popover.click()},a.onTabChange=function(e){var t=a.props.onTabChange;t(e)},a}return(0,m.default)(t,e),(0,s.default)(t,[{key:"getNotificationBox",value:function(){var e=this,t=this.props,a=t.children,n=t.loading,l=t.locale;if(!a)return null;var o=g.default.Children.map(a,function(t){var a=t.props.list&&t.props.list.length>0?"".concat(t.props.title," (").concat(t.props.list.length,")"):t.props.title;return g.default.createElement(M,{tab:a,key:t.props.name},g.default.createElement(b.default,(0,d.default)({},t.props,{data:t.props.list,onClick:function(a){return e.onItemClick(a,t.props)},onClear:function(){return e.onClear(t.props.name)},title:t.props.title,locale:l})))});return g.default.createElement(u.default,{spinning:n,delay:0},g.default.createElement(h.default,{className:E.default.tabs,onChange:this.onTabChange},o))}},{key:"render",value:function(){var e=this,t=this.props,a=t.className,n=t.count,l=t.popupAlign,u=t.popupVisible,c=t.onPopupVisibleChange,s=t.bell,f=(0,y.default)(a,E.default.noticeButton),p=this.getNotificationBox(),m=s||g.default.createElement(i.default,{type:"bell",className:E.default.icon}),h=g.default.createElement("span",{className:f},g.default.createElement(r.default,{count:n,style:{boxShadow:"none"},className:E.default.badge},m));if(!p)return h;var b={};return"popupVisible"in this.props&&(b.visible=u),g.default.createElement(o.default,(0,d.default)({placement:"bottomRight",content:p,popupClassName:E.default.popover,trigger:"click",arrowPointAtCenter:!0,popupAlign:l,onVisibleChange:c},b,{ref:function(t){e.popover=v.default.findDOMNode(t)}}),h)}}]),t}(g.PureComponent);t.default=x,x.Tab=M,x.defaultProps={onItemClick:function(){},onPopupVisibleChange:function(){},onTabChange:function(){},onClear:function(){},loading:!1,clearClose:!1,locale:{emptyText:"No notifications",clear:"Clear"},emptyImage:"https://gw.alipayobjects.com/zos/rmsportal/wAhyIChODzsoKIOBHcBk.svg"}},AcjU:function(e,t,a){"use strict";var n=a("3rQ3"),l=a("xK3H");Object.defineProperty(t,"__esModule",{value:!0}),t.default=t.getMenuMatchKeys=t.getFlatMenuKeys=void 0;var o=l(a("dnxz")),r=l(a("9bEj")),i=l(a("aG3W")),u=l(a("Sx57")),d=l(a("4zp0")),c=l(a("iVWQ")),s=l(a("lF+r")),f=l(a("PApH"));a("wSQP");var p=l(a("+U1r")),m=n(a("zLBQ")),h=l(a("UaMt")),g=l(a("iczh")),v=l(a("D/dJ")),y=l(a("mR0u")),b=n(a("oFg3")),E=a("S/9j"),M=p.default.Sider,x=function(e){var t=e.location.pathname,a=e.flatMenuKeys;return(0,E.urlToList)(t).map(function(e){return(0,b.getMenuMatches)(a,e)[0]}).filter(function(e){return e})},k=function e(t){return t.reduce(function(t,a){return t.push(a.path),a.children?t.concat(e(a.children)):t},[])};t.getFlatMenuKeys=k;var C=function(e,t){return t.reduce(function(t,a){return t.concat(e.filter(function(e){return(0,h.default)(e).test(a)}))},[])};t.getMenuMatchKeys=C;var N=function(e){function t(e){var a;return(0,u.default)(this,t),a=(0,c.default)(this,(0,s.default)(t).call(this,e)),a.isMainMenu=function(e){var t=a.props.menuData;return t.some(function(t){return!!e&&(t.key===e||t.path===e)})},a.handleOpenChange=function(e){var t=e.filter(function(e){return a.isMainMenu(e)}).length>1;a.setState({openKeys:t?[e.pop()]:(0,i.default)(e)})},a.flatMenuKeys=k(e.menuData),a.state={openKeys:x(e)},a}return(0,f.default)(t,e),(0,d.default)(t,[{key:"render",value:function(){var e,t=this.props,a=t.logo,n=t.collapsed,l=t.onCollapse,i=t.fixSiderbar,u=t.theme,d=this.state.openKeys,c=n?{}:{openKeys:d},s=(0,g.default)(y.default.sider,(e={},(0,r.default)(e,y.default.fixSiderbar,i),(0,r.default)(e,y.default.light,"light"===u),e));return m.default.createElement(M,{trigger:null,collapsible:!0,collapsed:n,breakpoint:"lg",onCollapse:l,width:256,theme:u,className:s},m.default.createElement("div",{className:y.default.logo,id:"logo"},m.default.createElement(v.default,{to:"/"},m.default.createElement("img",{src:a,alt:"logo"}),m.default.createElement("h1",null,"\u53f8\u6cd5\u9274\u5b9a\u4e91\u5e73\u53f0"))),m.default.createElement(b.default,(0,o.default)({},this.props,{mode:"inline",handleOpenChange:this.handleOpenChange,onOpenChange:this.handleOpenChange,style:{padding:"16px 0",width:"100%",overflowX:"hidden"}},c)))}}],[{key:"getDerivedStateFromProps",value:function(e,t){var a=t.pathname;return e.location.pathname!==a?{pathname:e.location.pathname,openKeys:x(e)}:null}}]),t}(m.PureComponent);t.default=N},BFsb:function(e,t,a){e.exports={content:"antd-pro\\components\\-setting-drawer\\index-content",blockChecbox:"antd-pro\\components\\-setting-drawer\\index-blockChecbox",item:"antd-pro\\components\\-setting-drawer\\index-item",selectIcon:"antd-pro\\components\\-setting-drawer\\index-selectIcon",color_block:"antd-pro\\components\\-setting-drawer\\index-color_block",title:"antd-pro\\components\\-setting-drawer\\index-title",handle:"antd-pro\\components\\-setting-drawer\\index-handle",productionHint:"antd-pro\\components\\-setting-drawer\\index-productionHint"}},BsfW:function(e,t,a){e.exports={list:"antd-pro\\components\\-notice-icon\\-notice-list-list",item:"antd-pro\\components\\-notice-icon\\-notice-list-item",meta:"antd-pro\\components\\-notice-icon\\-notice-list-meta",avatar:"antd-pro\\components\\-notice-icon\\-notice-list-avatar",iconElement:"antd-pro\\components\\-notice-icon\\-notice-list-iconElement",read:"antd-pro\\components\\-notice-icon\\-notice-list-read",title:"antd-pro\\components\\-notice-icon\\-notice-list-title",description:"antd-pro\\components\\-notice-icon\\-notice-list-description",datetime:"antd-pro\\components\\-notice-icon\\-notice-list-datetime",extra:"antd-pro\\components\\-notice-icon\\-notice-list-extra",notFound:"antd-pro\\components\\-notice-icon\\-notice-list-notFound",clear:"antd-pro\\components\\-notice-icon\\-notice-list-clear"}},IGtV:function(e,t,a){e.exports={fixedHeader:"antd-pro\\layouts\\-header-fixedHeader"}},IamK:function(e,t,a){"use strict";var n=a("xK3H");Object.defineProperty(t,"__esModule",{value:!0}),t.default=void 0,a("I4uq");var l=n(a("sSoI")),o=n(a("dnxz")),r=n(a("zLBQ")),i=n(a("AcjU")),u=function e(t){var a=[];return t.forEach(function(t){t.children&&(a=a.concat(e(t.children))),a.push(t.path)}),a},d=function(e){var t=e.isMobile,a=e.menuData,n=e.collapsed,d=e.onCollapse;return t?r.default.createElement(l.default,{visible:!n,placement:"left",onClose:function(){return d(!0)},style:{padding:0,height:"100vh"}},r.default.createElement(i.default,(0,o.default)({},e,{flatMenuKeys:u(a),collapsed:!t&&n}))):r.default.createElement(i.default,(0,o.default)({},e,{flatMenuKeys:u(a)}))},c=d;t.default=c},JwhZ:function(e,t,a){e.exports={head:"antd-pro\\components\\-top-nav-header\\index-head",light:"antd-pro\\components\\-top-nav-header\\index-light",main:"antd-pro\\components\\-top-nav-header\\index-main",wide:"antd-pro\\components\\-top-nav-header\\index-wide",left:"antd-pro\\components\\-top-nav-header\\index-left",right:"antd-pro\\components\\-top-nav-header\\index-right",logo:"antd-pro\\components\\-top-nav-header\\index-logo"}},NtFa:function(e,t,a){"use strict";var n=a("xK3H"),l=a("3rQ3");Object.defineProperty(t,"__esModule",{value:!0}),t.default=void 0,a("1pPU");var o,r,i=n(a("KjZ1")),u=n(a("Sx57")),d=n(a("4zp0")),c=n(a("iVWQ")),s=n(a("lF+r")),f=n(a("PApH")),p=n(a("vjBd")),m=l(a("zLBQ")),h=n(a("D/dJ")),g=n(a("zZ0I")),v=n(a("h3zL")),y=n(a("X5mu")),b=(o=(0,g.default)(600),r=function(e){function t(){var e,a;(0,u.default)(this,t);for(var n=arguments.length,l=new Array(n),o=0;o<n;o++)l[o]=arguments[o];return a=(0,c.default)(this,(e=(0,s.default)(t)).call.apply(e,[this].concat(l))),a.toggle=function(){var e=a.props,t=e.collapsed,n=e.onCollapse;n(!t),a.triggerResizeEvent()},a}return(0,f.default)(t,e),(0,d.default)(t,[{key:"componentWillUnmount",value:function(){this.triggerResizeEvent.cancel()}},{key:"triggerResizeEvent",value:function(){var e=document.createEvent("HTMLEvents");e.initEvent("resize",!0,!1),window.dispatchEvent(e)}},{key:"render",value:function(){var e=this.props,t=e.collapsed,a=e.isMobile,n=e.logo;return m.default.createElement("div",{className:v.default.header},a&&m.default.createElement(h.default,{to:"/",className:v.default.logo,key:"logo"},m.default.createElement("img",{src:n,alt:"logo",width:"32"})),m.default.createElement(i.default,{className:v.default.trigger,type:t?"menu-unfold":"menu-fold",onClick:this.toggle}),m.default.createElement(y.default,this.props))}}]),t}(m.PureComponent),(0,p.default)(r.prototype,"triggerResizeEvent",[o],Object.getOwnPropertyDescriptor(r.prototype,"triggerResizeEvent"),r.prototype),r);t.default=b},PceP:function(e,t,a){"use strict";var n=a("xK3H"),l=a("3rQ3");Object.defineProperty(t,"__esModule",{value:!0}),t.default=void 0,a("I4uq");var o=n(a("sSoI"));a("9j1q");var r=n(a("sLBh"));a("Lzml");var i=n(a("vpm+"));a("Ktq0");var u=n(a("fL5V"));a("fThj");var d=n(a("cYEd"));a("1pPU");var c=n(a("KjZ1"));a("khen");var s=n(a("3J+T"));a("79JM");var f=n(a("DmMy"));a("hjCg");var p=n(a("Feml")),m=n(a("Sx57")),h=n(a("4zp0")),g=n(a("iVWQ")),v=n(a("lF+r")),y=n(a("PApH")),b=n(a("SeLb"));a("E2ON");var E,M,x=n(a("jjSt")),k=l(a("zLBQ")),C=a("0iMl"),N=a("9AHN"),S=a("LneV"),P=n(a("k8Vd")),z=n(a("BFsb")),w=n(a("WJM/")),H=n(a("Pjk0")),I=x.default.Option,K=function(e){var t=e.children,a=e.title,n=e.style;return k.default.createElement("div",{style:(0,b.default)({},n,{marginBottom:24})},k.default.createElement("h3",{className:z.default.title},a),t)},j=(E=(0,S.connect)(function(e){var t=e.setting;return{setting:t}}),E(M=function(e){function t(){var e,a;(0,m.default)(this,t);for(var n=arguments.length,l=new Array(n),o=0;o<n;o++)l[o]=arguments[o];return a=(0,g.default)(this,(e=(0,v.default)(t)).call.apply(e,[this].concat(l))),a.state={collapse:!1},a.getLayoutSetting=function(){var e=a.props.setting,t=e.contentWidth,n=e.fixedHeader,l=e.layout,o=e.autoHideHeader,r=e.fixSiderbar;return[{title:(0,C.formatMessage)({id:"app.setting.content-width"}),action:k.default.createElement(x.default,{value:t,size:"small",onSelect:function(e){return a.changeSetting("contentWidth",e)},style:{width:80}},"sidemenu"===l?null:k.default.createElement(I,{value:"Fixed"},(0,C.formatMessage)({id:"app.setting.content-width.fixed"})),k.default.createElement(I,{value:"Fluid"},(0,C.formatMessage)({id:"app.setting.content-width.fluid"})))},{title:(0,C.formatMessage)({id:"app.setting.fixedheader"}),action:k.default.createElement(p.default,{size:"small",checked:!!n,onChange:function(e){return a.changeSetting("fixedHeader",e)}})},{title:(0,C.formatMessage)({id:"app.setting.hideheader"}),disabled:!n,disabledReason:(0,C.formatMessage)({id:"app.setting.hideheader.hint"}),action:k.default.createElement(p.default,{size:"small",checked:!!o,onChange:function(e){return a.changeSetting("autoHideHeader",e)}})},{title:(0,C.formatMessage)({id:"app.setting.fixedsidebar"}),disabled:"topmenu"===l,disabledReason:(0,C.formatMessage)({id:"app.setting.fixedsidebar.hint"}),action:k.default.createElement(p.default,{size:"small",checked:!!r,onChange:function(e){return a.changeSetting("fixSiderbar",e)}})}]},a.changeSetting=function(e,t){var n=a.props.setting,l=(0,b.default)({},n);l[e]=t,"layout"===e?l.contentWidth="topmenu"===t?"Fixed":"Fluid":"fixedHeader"!==e||t||(l.autoHideHeader=!1),a.setState(l,function(){var e=a.props.dispatch;e({type:"setting/changeSetting",payload:a.state})})},a.togglerContent=function(){var e=a.state.collapse;a.setState({collapse:!e})},a.renderLayoutSettingItem=function(e){var t=k.default.cloneElement(e.action,{disabled:e.disabled});return k.default.createElement(s.default,{title:e.disabled?e.disabledReason:"",placement:"left"},k.default.createElement(f.default.Item,{actions:[t]},k.default.createElement("span",{style:{opacity:e.disabled?"0.5":""}},e.title)))},a}return(0,y.default)(t,e),(0,h.default)(t,[{key:"render",value:function(){var e=this,t=this.props.setting,a=t.navTheme,n=t.primaryColor,l=t.layout,s=t.colorWeak,m=this.state.collapse;return k.default.createElement(o.default,{visible:m,width:300,onClose:this.togglerContent,placement:"right",handler:k.default.createElement("div",{className:z.default.handle},k.default.createElement(c.default,{type:m?"close":"setting",style:{color:"#fff",fontSize:20}})),onHandleClick:this.togglerContent,style:{zIndex:999}},k.default.createElement("div",{className:z.default.content},k.default.createElement(K,{title:(0,C.formatMessage)({id:"app.setting.pagestyle"})},k.default.createElement(H.default,{list:[{key:"dark",url:"https://gw.alipayobjects.com/zos/rmsportal/LCkqqYNmvBEbokSDscrm.svg",title:(0,C.formatMessage)({id:"app.setting.pagestyle.dark"})},{key:"light",url:"https://gw.alipayobjects.com/zos/rmsportal/jpRkZQMyYRryryPNtyIC.svg",title:(0,C.formatMessage)({id:"app.setting.pagestyle.light"})}],value:a,onChange:function(t){return e.changeSetting("navTheme",t)}})),k.default.createElement(w.default,{title:(0,C.formatMessage)({id:"app.setting.themecolor"}),value:n,onChange:function(t){return e.changeSetting("primaryColor",t)}}),k.default.createElement(d.default,null),k.default.createElement(K,{title:(0,C.formatMessage)({id:"app.setting.navigationmode"})},k.default.createElement(H.default,{list:[{key:"sidemenu",url:"https://gw.alipayobjects.com/zos/rmsportal/JopDzEhOqwOjeNTXkoje.svg",title:(0,C.formatMessage)({id:"app.setting.sidemenu"})},{key:"topmenu",url:"https://gw.alipayobjects.com/zos/rmsportal/KDNDBbriJhLwuqMoxcAr.svg",title:(0,C.formatMessage)({id:"app.setting.topmenu"})}],value:l,onChange:function(t){return e.changeSetting("layout",t)}})),k.default.createElement(f.default,{split:!1,dataSource:this.getLayoutSetting(),renderItem:this.renderLayoutSettingItem}),k.default.createElement(d.default,null),k.default.createElement(K,{title:(0,C.formatMessage)({id:"app.setting.othersettings"})},k.default.createElement(f.default.Item,{actions:[k.default.createElement(p.default,{size:"small",checked:!!s,onChange:function(t){return e.changeSetting("colorWeak",t)}})]},(0,C.formatMessage)({id:"app.setting.weakmode"}))),k.default.createElement(d.default,null),k.default.createElement(N.CopyToClipboard,{text:JSON.stringify((0,P.default)(t,["colorWeak"]),null,2),onCopy:function(){return u.default.success((0,C.formatMessage)({id:"app.setting.copyinfo"}))}},k.default.createElement(i.default,{block:!0,icon:"copy"},(0,C.formatMessage)({id:"app.setting.copy"}))),k.default.createElement(r.default,{type:"warning",className:z.default.productionHint,message:k.default.createElement("div",null,(0,C.formatMessage)({id:"app.setting.production.hint"})," ",k.default.createElement("a",{href:"https://u.ant.design/pro-v2-default-settings",target:"_blank",rel:"noopener noreferrer"},"src/defaultSettings.js"))})))}}]),t}(k.PureComponent))||M),F=j;t.default=F},Pjk0:function(e,t,a){"use strict";var n=a("xK3H");Object.defineProperty(t,"__esModule",{value:!0}),t.default=void 0,a("khen");var l=n(a("3J+T"));a("1pPU");var o=n(a("KjZ1")),r=n(a("zLBQ")),i=n(a("BFsb")),u=function(e){var t=e.value,a=e.onChange,n=e.list;return r.default.createElement("div",{className:i.default.blockChecbox,key:t},n.map(function(e){return r.default.createElement(l.default,{title:e.title,key:e.key},r.default.createElement("div",{className:i.default.item,onClick:function(){return a(e.key)}},r.default.createElement("img",{src:e.url,alt:e.key}),r.default.createElement("div",{className:i.default.selectIcon,style:{display:t===e.key?"block":"none"}},r.default.createElement(o.default,{type:"check"}))))}))},d=u;t.default=d},SlZz:function(e,t,a){"use strict";var n=a("xK3H");Object.defineProperty(t,"__esModule",{value:!0}),t.default=c,a("79JM");var l=n(a("DmMy"));a("sXHd");var o=n(a("oEbq")),r=n(a("9bEj")),i=n(a("zLBQ")),u=n(a("iczh")),d=n(a("BsfW"));function c(e){var t=e.data,a=void 0===t?[]:t,n=e.onClick,c=e.onClear,s=e.title,f=e.locale,p=e.emptyText,m=e.emptyImage,h=e.showClear,g=void 0===h||h;return 0===a.length?i.default.createElement("div",{className:d.default.notFound},m?i.default.createElement("img",{src:m,alt:"not found"}):null,i.default.createElement("div",null,p||f.emptyText)):i.default.createElement("div",null,i.default.createElement(l.default,{className:d.default.list},a.map(function(e,t){var a=(0,u.default)(d.default.item,(0,r.default)({},d.default.read,e.read)),c=e.avatar?"string"===typeof e.avatar?i.default.createElement(o.default,{className:d.default.avatar,src:e.avatar}):e.avatar:null;return i.default.createElement(l.default.Item,{className:a,key:e.key||t,onClick:function(){return n(e)}},i.default.createElement(l.default.Item.Meta,{className:d.default.meta,avatar:i.default.createElement("span",{className:d.default.iconElement},c),title:i.default.createElement("div",{className:d.default.title},e.title,i.default.createElement("div",{className:d.default.extra},e.extra)),description:i.default.createElement("div",null,i.default.createElement("div",{className:d.default.description,title:e.description},e.description),i.default.createElement("div",{className:d.default.datetime},e.datetime))}))})),g?i.default.createElement("div",{className:d.default.clear,onClick:c},f.clear," ",s):null)}},"WJM/":function(e,t,a){"use strict";var n=a("xK3H");Object.defineProperty(t,"__esModule",{value:!0}),t.default=void 0,a("khen");var l=n(a("3J+T")),o=n(a("dnxz"));a("1pPU");var r=n(a("KjZ1")),i=n(a("+S5U")),u=n(a("zLBQ")),d=a("0iMl"),c=n(a("4Ofr")),s=function(e){var t=e.color,a=e.check,n=(0,i.default)(e,["color","check"]);return u.default.createElement("div",(0,o.default)({},n,{style:{backgroundColor:t}}),a?u.default.createElement(r.default,{type:"check"}):"")},f=function(e){var t=e.colors,a=e.title,n=e.value,o=e.onChange,r=t;return t||(r=[{key:"dust",color:"#F5222D"},{key:"volcano",color:"#FA541C"},{key:"sunset",color:"#FAAD14"},{key:"cyan",color:"#13C2C2"},{key:"green",color:"#52C41A"},{key:"daybreak",color:"#1890FF"},{key:"geekblue",color:"#2F54EB"},{key:"purple",color:"#722ED1"}]),u.default.createElement("div",{className:c.default.themeColor},u.default.createElement("h3",{className:c.default.title},a),u.default.createElement("div",{className:c.default.content},r.map(function(e){var t=e.key,a=e.color;return u.default.createElement(l.default,{key:a,title:(0,d.formatMessage)({id:"app.setting.themecolor.".concat(t)})},u.default.createElement(s,{className:c.default.colorBlock,color:a,check:n===a,onClick:function(){return o&&o(a)}}))})))},p=f;t.default=p},X5mu:function(e,t,a){"use strict";var n=a("3rQ3"),l=a("xK3H");Object.defineProperty(t,"__esModule",{value:!0}),t.default=void 0,a("bQCI");var o=l(a("lMRA"));a("v0Pg");var r=l(a("Byrh"));a("sXHd");var i=l(a("oEbq"));a("VfWj");var u=l(a("Otdh"));a("1pPU");var d=l(a("KjZ1"));a("kKuL");var c=l(a("hs2k")),s=l(a("SeLb")),f=l(a("Sx57")),p=l(a("4zp0")),m=l(a("iVWQ")),h=l(a("lF+r")),g=l(a("PApH")),v=n(a("zLBQ")),y=a("0iMl"),b=l(a("I9Uw")),E=l(a("A2NP")),M=l(a("8TWP")),x=l(a("h3zL")),k=function(e){function t(){return(0,f.default)(this,t),(0,m.default)(this,(0,h.default)(t).apply(this,arguments))}return(0,g.default)(t,e),(0,p.default)(t,[{key:"getNoticeData",value:function(){var e=this.props.notices,t=void 0===e?[]:e;if(0===t.length)return{};var a=t.map(function(e){var t=(0,s.default)({},e);if(t.datetime&&(t.datetime=(0,b.default)(e.datetime).fromNow()),t.id&&(t.key=t.id),t.extra&&t.status){var a={todo:"",processing:"blue",urgent:"red",doing:"gold"}[t.status];t.extra=v.default.createElement(c.default,{color:a,style:{marginRight:0}},t.extra)}return t});return(0,E.default)(a,"type")}},{key:"render",value:function(){var e=this.props,t=e.currentUser,a=e.fetchingNotices,n=e.onNoticeVisibleChange,l=e.onMenuClick,c=e.onNoticeClear,s=e.theme,f=v.default.createElement(u.default,{className:x.default.menu,selectedKeys:[],onClick:l},v.default.createElement(u.default.Item,{key:"userCenter"},v.default.createElement(d.default,{type:"user"}),v.default.createElement(y.FormattedMessage,{id:"menu.account.center",defaultMessage:"account center"})),v.default.createElement(u.default.Item,{key:"userinfo"},v.default.createElement(d.default,{type:"setting"}),v.default.createElement(y.FormattedMessage,{id:"menu.account.settings",defaultMessage:"account settings"})),v.default.createElement(u.default.Item,{key:"triggerError"},v.default.createElement(d.default,{type:"close-circle"}),v.default.createElement(y.FormattedMessage,{id:"menu.account.trigger",defaultMessage:"Trigger Error"})),v.default.createElement(u.default.Divider,null),v.default.createElement(u.default.Item,{key:"logout"},v.default.createElement(d.default,{type:"logout"}),v.default.createElement(y.FormattedMessage,{id:"menu.account.logout",defaultMessage:"logout"}))),p=this.getNoticeData(),m=x.default.right;return"dark"===s&&(m="".concat(x.default.right,"  ").concat(x.default.dark)),v.default.createElement("div",{className:m},v.default.createElement(M.default,{className:x.default.action,count:t.notifyCount,onItemClick:function(e,t){console.log(e,t)},locale:{emptyText:(0,y.formatMessage)({id:"component.noticeIcon.empty"}),clear:(0,y.formatMessage)({id:"component.noticeIcon.clear"})},onClear:c,onPopupVisibleChange:n,loading:a,popupAlign:{offset:[20,-16]},clearClose:!0},v.default.createElement(M.default.Tab,{list:p.notification,title:(0,y.formatMessage)({id:"component.globalHeader.notification"}),name:"notification",emptyText:(0,y.formatMessage)({id:"component.globalHeader.notification.empty"}),emptyImage:"https://gw.alipayobjects.com/zos/rmsportal/wAhyIChODzsoKIOBHcBk.svg"}),v.default.createElement(M.default.Tab,{list:p.message,title:(0,y.formatMessage)({id:"component.globalHeader.message"}),name:"message",emptyText:(0,y.formatMessage)({id:"component.globalHeader.message.empty"}),emptyImage:"https://gw.alipayobjects.com/zos/rmsportal/sAuJeJzSKbUmHfBQRzmZ.svg"}),v.default.createElement(M.default.Tab,{list:p.event,title:(0,y.formatMessage)({id:"component.globalHeader.event"}),name:"event",emptyText:(0,y.formatMessage)({id:"component.globalHeader.event.empty"}),emptyImage:"https://gw.alipayobjects.com/zos/rmsportal/HsIsxMZiWKrNUavQUXqx.svg"})),t.name?v.default.createElement(r.default,{overlay:f},v.default.createElement("span",{className:"".concat(x.default.action," ").concat(x.default.account)},v.default.createElement(i.default,{size:"small",className:x.default.avatar,src:t.avatar,alt:"avatar"}),v.default.createElement("span",{className:x.default.name},t.name))):v.default.createElement(o.default,{size:"small",style:{marginLeft:8,marginRight:8}}))}}]),t}(v.PureComponent);t.default=k},btmg:function(e,t,a){e.exports={popover:"antd-pro\\components\\-notice-icon\\index-popover",noticeButton:"antd-pro\\components\\-notice-icon\\index-noticeButton",icon:"antd-pro\\components\\-notice-icon\\index-icon",tabs:"antd-pro\\components\\-notice-icon\\index-tabs"}},ctiy:function(e,t,a){"use strict";var n=a("3rQ3"),l=a("xK3H");Object.defineProperty(t,"__esModule",{value:!0}),t.default=void 0;var o=l(a("dnxz"));a("Ktq0");var r=l(a("fL5V")),i=l(a("Sx57")),u=l(a("4zp0")),d=l(a("iVWQ")),c=l(a("lF+r")),s=l(a("PApH"));a("wSQP");var f=l(a("+U1r")),p=n(a("zLBQ")),m=a("0iMl"),h=l(a("HKyQ")),g=a("LneV"),v=l(a("r27q")),y=l(a("NtFa")),b=l(a("wWO0")),E=l(a("IGtV")),M=l(a("HZnN")),x=f.default.Header,k=function(e){function t(){var e,a;(0,i.default)(this,t);for(var n=arguments.length,l=new Array(n),o=0;o<n;o++)l[o]=arguments[o];return a=(0,d.default)(this,(e=(0,c.default)(t)).call.apply(e,[this].concat(l))),a.state={visible:!0},a.getHeadWidth=function(){var e=a.props,t=e.isMobile,n=e.collapsed,l=e.setting,o=l.fixedHeader,r=l.layout;return t||!o||"topmenu"===r?"100%":n?"calc(100% - 80px)":"calc(100% - 256px)"},a.handleNoticeClear=function(e){r.default.success("".concat((0,m.formatMessage)({id:"component.noticeIcon.cleared"})," ").concat((0,m.formatMessage)({id:"component.globalHeader.".concat(e)})));var t=a.props.dispatch;t({type:"global/clearNotices",payload:e})},a.handleMenuClick=function(e){var t=e.key,n=a.props.dispatch;"userCenter"!==t?"triggerError"!==t?"userinfo"!==t?"logout"===t&&n({type:"login/logout"}):v.default.push("/account/settings/base"):v.default.push("/exception/trigger"):v.default.push("/account/center")},a.handleNoticeVisibleChange=function(e){if(e){var t=a.props.dispatch;t({type:"global/fetchNotices"})}},a.handScroll=function(){var e=a.props.autoHideHeader,t=a.state.visible;if(e){var n=document.body.scrollTop+document.documentElement.scrollTop;a.ticking||(a.ticking=!0,requestAnimationFrame(function(){a.oldScrollTop>n&&a.setState({visible:!0}),n>300&&t&&a.setState({visible:!1}),n<300&&!t&&a.setState({visible:!0}),a.oldScrollTop=n,a.ticking=!1}))}},a}return(0,s.default)(t,e),(0,u.default)(t,[{key:"componentDidMount",value:function(){document.addEventListener("scroll",this.handScroll,{passive:!0})}},{key:"componentWillUnmount",value:function(){document.removeEventListener("scroll",this.handScroll)}},{key:"render",value:function(){var e=this.props,t=e.isMobile,a=e.handleMenuCollapse,n=e.setting,l=n.navTheme,r=n.layout,i=n.fixedHeader,u=this.state.visible,d="topmenu"===r,c=this.getHeadWidth(),s=u?p.default.createElement(x,{style:{padding:0,width:c},className:i?E.default.fixedHeader:""},d&&!t?p.default.createElement(b.default,(0,o.default)({theme:l,mode:"horizontal",Authorized:M.default,onCollapse:a,onNoticeClear:this.handleNoticeClear,onMenuClick:this.handleMenuClick,onNoticeVisibleChange:this.handleNoticeVisibleChange},this.props)):p.default.createElement(y.default,(0,o.default)({onCollapse:a,onNoticeClear:this.handleNoticeClear,onMenuClick:this.handleMenuClick,onNoticeVisibleChange:this.handleNoticeVisibleChange},this.props))):null;return p.default.createElement(h.default,{component:"",transitionName:"fade"},s)}}],[{key:"getDerivedStateFromProps",value:function(e,t){return e.autoHideHeader||t.visible?null:{visible:!0}}}]),t}(p.PureComponent),C=(0,g.connect)(function(e){var t=e.user,a=e.global,n=e.setting,l=e.loading;return{currentUser:t.currentUser,collapsed:a.collapsed,fetchingNotices:l.effects["global/fetchNotices"],notices:a.notices,setting:n}})(k);t.default=C},h3zL:function(e,t,a){e.exports={header:"antd-pro\\components\\-global-header\\index-header",logo:"antd-pro\\components\\-global-header\\index-logo",menu:"antd-pro\\components\\-global-header\\index-menu",trigger:"antd-pro\\components\\-global-header\\index-trigger",right:"antd-pro\\components\\-global-header\\index-right",action:"antd-pro\\components\\-global-header\\index-action",search:"antd-pro\\components\\-global-header\\index-search",account:"antd-pro\\components\\-global-header\\index-account",avatar:"antd-pro\\components\\-global-header\\index-avatar",dark:"antd-pro\\components\\-global-header\\index-dark",name:"antd-pro\\components\\-global-header\\index-name"}},m8Tn:function(e,t,a){"use strict";var n=a("xK3H");Object.defineProperty(t,"__esModule",{value:!0}),t.default=void 0;var l=n(a("dnxz")),o=n(a("Sx57")),r=n(a("4zp0")),i=n(a("iVWQ")),u=n(a("lF+r")),d=n(a("PApH")),c=n(a("SeLb"));a("wSQP");var s=n(a("+U1r")),f=n(a("zLBQ")),p=n(a("Cjad")),m=n(a("yKc7")),h=n(a("pkaF")),g=a("LneV"),v=a("RVbP"),y=n(a("iczh")),b=n(a("UaMt")),E=a("NO6H"),M=a("0iMl"),x=n(a("IamK")),k=n(a("HZnN")),C=(n(a("PceP")),n(a("mxmt"))),N=n(a("ctiy")),S=n(a("R1Dz")),P=n(a("wOmh")),z=s.default.Content;function w(e,t,a){return e.map(function(e){if(!e.name||!e.path)return null;var n="menu";n=a?"".concat(a,".").concat(e.name):"menu.".concat(e.name);var l=(0,c.default)({},e,{name:(0,M.formatMessage)({id:n,defaultMessage:e.name}),locale:n,authority:e.authority||t});if(e.routes){var o=w(e.routes,e.authority,n);l.children=o}return delete l.routes,l}).filter(function(e){return e})}var H=(0,h.default)(w,m.default),I={"screen-xs":{maxWidth:575},"screen-sm":{minWidth:576,maxWidth:767},"screen-md":{minWidth:768,maxWidth:991},"screen-lg":{minWidth:992,maxWidth:1199},"screen-xl":{minWidth:1200,maxWidth:1599},"screen-xxl":{minWidth:1600}},K=function(e){function t(e){var a;return(0,o.default)(this,t),a=(0,i.default)(this,(0,u.default)(t).call(this,e)),a.state={rendering:!0,isMobile:!1,menuData:a.getMenuData()},a.matchParamsPath=function(e){var t=Object.keys(a.breadcrumbNameMap).find(function(t){return(0,b.default)(t).test(e)});return a.breadcrumbNameMap[t]},a.getPageTitle=function(e){var t=a.matchParamsPath(e);if(!t)return"Ant Design Pro";var n=(0,M.formatMessage)({id:t.locale||t.name,defaultMessage:t.name});return"".concat(n," - \u53f8\u6cd5\u9274\u5b9a\u4e91\u5e73\u53f0")},a.getLayoutStyle=function(){var e=a.state.isMobile,t=a.props,n=t.fixSiderbar,l=t.collapsed,o=t.layout;return n&&"topmenu"!==o&&!e?{paddingLeft:l?"80px":"256px"}:null},a.getContentStyle=function(){var e=a.props.fixedHeader;return{margin:"24px 24px 0",paddingTop:e?64:0}},a.handleMenuCollapse=function(e){var t=a.props.dispatch;t({type:"global/changeLayoutCollapsed",payload:e})},a.getPageTitle=(0,h.default)(a.getPageTitle),a.getBreadcrumbNameMap=(0,h.default)(a.getBreadcrumbNameMap,m.default),a.breadcrumbNameMap=a.getBreadcrumbNameMap(),a.matchParamsPath=(0,h.default)(a.matchParamsPath,m.default),a}return(0,d.default)(t,e),(0,r.default)(t,[{key:"componentDidMount",value:function(){var e=this,t=this.props.dispatch;t({type:"user/fetchCurrent"}),t({type:"setting/getSetting"}),this.renderRef=requestAnimationFrame(function(){e.setState({rendering:!1})}),this.enquireHandler=(0,E.enquireScreen)(function(t){var a=e.state.isMobile;a!==t&&e.setState({isMobile:t})})}},{key:"componentDidUpdate",value:function(e){this.breadcrumbNameMap=this.getBreadcrumbNameMap();var t=this.state.isMobile,a=this.props.collapsed;!t||e.isMobile||a||this.handleMenuCollapse(!1)}},{key:"componentWillUnmount",value:function(){cancelAnimationFrame(this.renderRef),(0,E.unenquireScreen)(this.enquireHandler)}},{key:"getContext",value:function(){var e=this.props.location;return{location:e,breadcrumbNameMap:this.breadcrumbNameMap}}},{key:"getMenuData",value:function(){var e=this.props.route.routes;return H(e)}},{key:"getBreadcrumbNameMap",value:function(){var e={},t=function t(a){a.forEach(function(a){a.children&&t(a.children),e[a.path]=a})};return t(this.getMenuData()),e}},{key:"renderSettingDrawer",value:function(){this.state.rendering;return null}},{key:"render",value:function(){var e=this,t=this.props,a=t.navTheme,n=t.layout,o=t.children,r=t.location.pathname,i=this.state,u=i.isMobile,d=i.menuData,m="topmenu"===n,h=this.matchParamsPath(r),g=f.default.createElement(s.default,null,m&&!u?null:f.default.createElement(x.default,(0,l.default)({logo:C.default,Authorized:k.default,theme:a,onCollapse:this.handleMenuCollapse,menuData:d,isMobile:u},this.props)),f.default.createElement(s.default,{style:(0,c.default)({},this.getLayoutStyle(),{minHeight:"100vh"})},f.default.createElement(N.default,(0,l.default)({menuData:d,handleMenuCollapse:this.handleMenuCollapse,logo:C.default,isMobile:u},this.props)),f.default.createElement(z,{style:this.getContentStyle()},f.default.createElement(k.default,{authority:h&&h.authority,noMatch:f.default.createElement(P.default,null)},o))));return f.default.createElement(f.default.Fragment,null,f.default.createElement(p.default,{title:this.getPageTitle(r)},f.default.createElement(v.ContainerQuery,{query:I},function(t){return f.default.createElement(S.default.Provider,{value:e.getContext()},f.default.createElement("div",{className:(0,y.default)(t)},g))})),this.renderSettingDrawer())}}]),t}(f.default.PureComponent),j=(0,g.connect)(function(e){var t=e.global,a=e.setting;return(0,c.default)({collapsed:t.collapsed,layout:a.layout},a)})(K);t.default=j},mR0u:function(e,t,a){e.exports={logo:"antd-pro\\components\\-sider-menu\\index-logo",sider:"antd-pro\\components\\-sider-menu\\index-sider",fixSiderbar:"antd-pro\\components\\-sider-menu\\index-fixSiderbar",light:"antd-pro\\components\\-sider-menu\\index-light",icon:"antd-pro\\components\\-sider-menu\\index-icon"}},oFg3:function(e,t,a){"use strict";var n=a("3rQ3"),l=a("xK3H");Object.defineProperty(t,"__esModule",{value:!0}),t.default=t.getMenuMatches=void 0;var o=l(a("dnxz")),r=l(a("Sx57")),i=l(a("4zp0")),u=l(a("iVWQ")),d=l(a("lF+r")),c=l(a("PApH"));a("1pPU");var s=l(a("KjZ1"));a("VfWj");var f=l(a("Otdh")),p=n(a("zLBQ")),m=l(a("D/dJ")),h=l(a("yKc7")),g=l(a("pkaF")),v=l(a("UaMt")),y=a("S/9j"),b=l(a("mR0u")),E=f.default.SubMenu,M=function(e){return"string"===typeof e&&0===e.indexOf("http")?p.default.createElement("img",{src:e,alt:"icon",className:b.default.icon}):"string"===typeof e?p.default.createElement(s.default,{type:e}):e},x=function(e,t){return e.filter(function(e){return!!e&&(0,v.default)(e).test(t)})};t.getMenuMatches=x;var k=function(e){function t(e){var a;return(0,r.default)(this,t),a=(0,u.default)(this,(0,d.default)(t).call(this,e)),a.getNavMenuItems=function(e,t){return e?e.filter(function(e){return e.name&&!e.hideInMenu}).map(function(e){var n=a.getSubMenuOrItem(e,t);return a.checkPermissionItem(e.authority,n)}).filter(function(e){return e}):[]},a.getSelectedMenuKeys=function(e){return(0,y.urlToList)(e).map(function(e){return x(a.flatMenuKeys,e).pop()})},a.getSubMenuOrItem=function(e){if(e.children&&!e.hideChildrenInMenu&&e.children.some(function(e){return e.name})){var t=e.name;return p.default.createElement(E,{title:e.icon?p.default.createElement("span",null,M(e.icon),p.default.createElement("span",null,t)):t,key:e.path},a.getNavMenuItems(e.children))}return p.default.createElement(f.default.Item,{key:e.path},a.getMenuItemPath(e))},a.getMenuItemPath=function(e){var t=e.name,n=a.conversionPath(e.path),l=M(e.icon),o=e.target;if(/^https?:\/\//.test(n))return p.default.createElement("a",{href:n,target:o},l,p.default.createElement("span",null,t));var r=a.props,i=r.location,u=r.isMobile,d=r.onCollapse;return p.default.createElement(m.default,{to:n,target:o,replace:n===i.pathname,onClick:u?function(){d(!0)}:void 0},l,p.default.createElement("span",null,t))},a.checkPermissionItem=function(e,t){var n=a.props.Authorized;if(n&&n.check){var l=n.check;return l(e,t)}return t},a.conversionPath=function(e){return e&&0===e.indexOf("http")?e:"/".concat(e||"").replace(/\/+/g,"/")},a.getSelectedMenuKeys=(0,g.default)(a.getSelectedMenuKeys,h.default),a.flatMenuKeys=a.getFlatMenuKeys(e.menuData),a}return(0,c.default)(t,e),(0,i.default)(t,[{key:"getFlatMenuKeys",value:function(e){var t=this,a=[];return e.forEach(function(e){e.children&&(a=a.concat(t.getFlatMenuKeys(e.children))),a.push(e.path)}),a}},{key:"render",value:function(){var e=this.props,t=e.openKeys,a=e.theme,n=e.mode,l=e.location.pathname,r=this.getSelectedMenuKeys(l);!r.length&&t&&(r=[t[t.length-1]]);var i={};t&&(i={openKeys:t});var u=this.props,d=u.handleOpenChange,c=u.style,s=u.menuData;return p.default.createElement(f.default,(0,o.default)({key:"Menu",mode:n,theme:a,onOpenChange:d,selectedKeys:r,style:c,className:"horizontal"===n?"top-nav-menu":""},i),this.getNavMenuItems(s))}}]),t}(p.PureComponent);t.default=k},wWO0:function(e,t,a){"use strict";var n=a("3rQ3"),l=a("xK3H");Object.defineProperty(t,"__esModule",{value:!0}),t.default=void 0;var o=l(a("dnxz")),r=l(a("Sx57")),i=l(a("4zp0")),u=l(a("iVWQ")),d=l(a("lF+r")),c=l(a("PApH")),s=n(a("zLBQ")),f=l(a("D/dJ")),p=l(a("X5mu")),m=l(a("oFg3")),h=l(a("JwhZ")),g=function(e){function t(){var e,a;(0,r.default)(this,t);for(var n=arguments.length,l=new Array(n),o=0;o<n;o++)l[o]=arguments[o];return a=(0,u.default)(this,(e=(0,d.default)(t)).call.apply(e,[this].concat(l))),a.state={maxWidth:void 0},a}return(0,c.default)(t,e),(0,i.default)(t,[{key:"render",value:function(){var e=this,t=this.props,a=t.theme,n=t.contentWidth,l=t.logo,r=this.state.maxWidth;return s.default.createElement("div",{className:"".concat(h.default.head," ").concat("light"===a?h.default.light:"")},s.default.createElement("div",{ref:function(t){e.maim=t},className:"".concat(h.default.main," ").concat("Fixed"===n?h.default.wide:"")},s.default.createElement("div",{className:h.default.left},s.default.createElement("div",{className:h.default.logo,key:"logo",id:"logo"},s.default.createElement(f.default,{to:"/"},s.default.createElement("img",{src:l,alt:"logo"}),s.default.createElement("h1",null,"\u53f8\u6cd5\u9274\u5b9a\u4e91\u5e73\u53f0"))),s.default.createElement("div",{style:{maxWidth:r}},s.default.createElement(m.default,(0,o.default)({},this.props,{style:{border:"none",height:64}})))),s.default.createElement(p.default,this.props)))}}],[{key:"getDerivedStateFromProps",value:function(e){return{maxWidth:("Fixed"===e.contentWidth?1200:window.innerWidth)-280-165-40}}}]),t}(s.PureComponent);t.default=g}}]);