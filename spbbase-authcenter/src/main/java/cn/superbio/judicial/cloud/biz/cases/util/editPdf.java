package cn.superbio.judicial.cloud.biz.cases.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.awt.Color;

import com.itextpdf.text.Font;
import com.lowagie.text.pdf.*;
import com.lowagie.text.*;
import com.lowagie.text.pdf.draw.DottedLineSeparator;
import com.lowagie.text.pdf.draw.LineSeparator;
import com.lowagie.text.pdf.draw.VerticalPositionMark;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class editPdf {

    private static final Log log = LogFactory.getLog(editPdf.class);// 日志

    public static void main(String[] args) throws IOException, DocumentException {
        //页面大小
        Rectangle rect = new Rectangle(PageSize.A4.rotate());
        //页面背景色
        rect.setBackgroundColor(Color.WHITE);
        Document doc = new Document(rect);
        //路径
        OutputStream out = new FileOutputStream("D:/help.pdf");
        PdfWriter writer = PdfWriter.getInstance(doc, out);
        doc.open();
        //插入内容
        doc.add(new Paragraph("Hello World22"));
        //PDF版本(默认1.4)
        writer.setPdfVersion(PdfWriter.PDF_VERSION_1_2);
        //文档属性
        doc.addTitle("Title@sample");
        doc.addAuthor("Author@rensanning");
        doc.addSubject("Subject@iText sample");
        doc.addKeywords("Keywords@iText");
        doc.addCreator("Creator@iText");
        //页边空白(左__上__右__下)
        doc.setMargins(50, 80, 50, 50);
        doc.add(new Paragraph("First page"));
        //打印版本
        doc.add(new Paragraph(Document.getVersion()));
        //新建一页
        doc.newPage();
        //是否空页
        writer.setPageEmpty(false);
        doc.add(new Paragraph("New page"));

        //Chunk对象: a String, a Font, and some attributes
        //输入China
        doc.add(new Chunk("China"));
        //输入空格
        doc.add(new Chunk(" "));
        //需要添加的内容chinese
        Chunk id = new Chunk("chinese", FontFactory.getFont(FontFactory.HELVETICA,6, Font.UNDERLINE));
        //背景色以及背景范围
        id.setBackground(Color.YELLOW, 1f, 0.5f, 1f, 1.5f);
        //字号
        id.setTextRise(6);
        //添加
        doc.add(id);

        //新建一行
        doc.add(Chunk.NEWLINE);
        doc.add(new Chunk("Japan"));
        doc.add(new Chunk(" "));
        Chunk id2 = new Chunk("chinese", FontFactory.getFont(FontFactory.HELVETICA,6, Font.UNDERLINE));
        id2.setBackground(Color.YELLOW, 1f, 0.5f, 1f, 1.5f);
        id2.setTextRise(6);
        id2.setUnderline(0.2f, -2f);
        doc.add(id2);
        doc.add(Chunk.NEWLINE);

        //Phrase对象: a List of Chunks with leading
        doc.newPage();
        //输入Phrase page
        doc.add(new Phrase("Phrase page"));

        Phrase director = new Phrase();
        Chunk name = new Chunk("China");
        name.setUnderline(0.2f, -2f);
        //添加China 和其setUnderline的下划线
        director.add(name);
        director.add(new Chunk(","));
        director.add(new Chunk(" "));
        director.add(new Chunk("chinese"));
        //设置引导
        director.setLeading(24);
        doc.add(director);
        Phrase director2 = new Phrase();
        Chunk name2 = new Chunk("Japan");
        name2.setUnderline(0.2f, -2f);
        director2.add(name2);
        director2.add(new Chunk(","));
        director2.add(new Chunk(" "));
        director2.add(new Chunk("japanese"));
        director2.setLeading(24);
        doc.add(director2);

        //Paragraph对象: a Phrase with extra properties and a newline
        doc.newPage();
        //输入Paragraph page
        doc.add(new Paragraph("Paragraph page"));

        Paragraph info = new Paragraph();
        info.add(new Chunk("China "));
        info.add(new Chunk("chinese"));
        info.add(Chunk.NEWLINE);
        info.add(new Phrase("Japan "));
        info.add(new Phrase("japanese"));
        doc.add(info);
        //List对象: a sequence of Paragraphs called ListItem
        doc.newPage();
        List list = new List(List.ORDERED);
        for (int i = 0; i < 3; i++) {
            ListItem item = new ListItem(String.format("%s: %d movies", "country" + (i + 1), (i + 1) * 100),
                    FontFactory.getFont(FontFactory.HELVETICA,6, Font.UNDERLINE));
            List movielist = new List(List.ORDERED, List.ALPHABETICAL);
            movielist.setLowercase(List.LOWERCASE);
            //循环输出
            for (int j = 0; j < 5; j++) {
                ListItem movieitem = new ListItem("Title" + (j + 1));
                List directorlist = new List(List.UNORDERED);
                for (int k = 0; k < 3; k++) {
                    directorlist.add(String.format("%s, %s", "Name1" + (k + 1),"Name2" + (k + 1)));
                }
                movieitem.add(directorlist);
                movielist.add(movieitem);
            }
            item.add(movielist);
            list.add(item);
        }
        doc.add(list);

        //Anchor对象: internal and external links
        Paragraph country = new Paragraph();
        Anchor dest = new Anchor("china", FontFactory.getFont(FontFactory.HELVETICA,6, Font.UNDERLINE));
        //中文
        dest.setName("CN");
        dest.setReference("http://www.china.com");//external
        country.add(dest);
        country.add(String.format(": %d sites", 10000));
        doc.add(country);



        doc.newPage();
        Anchor toUS = new Anchor("Go to first page.", FontFactory.getFont(FontFactory.HELVETICA,6, Font.UNDERLINE));
        toUS.setReference("#CN");//internal
        doc.add(toUS);

        //Image对象
        doc.newPage();
        Image img = Image.getInstance("D:/1.jpg");
        img.setAlignment(Image.LEFT | Image.TEXTWRAP);
        img.setBorder(Image.BOX);
        img.setBorderWidth(10);
        img.setBorderColor(Color.WHITE);
        img.scaleToFit(1000, 72);//大小
        img.setRotationDegrees(-30);//旋转
        doc.add(img);

        //Chapter, Section对象（目录）
        doc.newPage();
        Paragraph title = new Paragraph("Title");
        Chapter chapter = new Chapter(title, 1);
        title = new Paragraph("Section A");
        Section section = chapter.addSection(title);
        section.setBookmarkTitle("bmk");
        section.setIndentation(30);
        section.setBookmarkOpen(false);
        section.setNumberStyle(Section.NUMBERSTYLE_DOTTED_WITHOUT_FINAL_DOT);
        Section subsection = section.addSection(new Paragraph("Sub Section A"));
        subsection.setIndentationLeft(20);
        subsection.setNumberDepth(1);
        doc.add(chapter);
        //画图
        //左右箭头
        doc.add(new VerticalPositionMark() {

            public void draw(PdfContentByte canvas, float llx, float lly,
                             float urx, float ury, float y) {
                canvas.beginText();
                BaseFont bf = null;
                try {
                    bf = BaseFont.createFont(BaseFont.ZAPFDINGBATS, "", BaseFont.EMBEDDED);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                canvas.setFontAndSize(bf, 12);

                // 左箭头（指向右）
                canvas.showTextAligned(Element.ALIGN_CENTER, String.valueOf((char) 220), llx - 10, y, 0);
                // 右箭头（指向左）
                canvas.showTextAligned(Element.ALIGN_CENTER, String.valueOf((char) 220), urx + 10, y + 8, 180);
                canvas.endText();
            }
        });

        //直线
        Paragraph p1 = new Paragraph("LEFT");
        p1.add(new Chunk(new LineSeparator()));
        p1.add("R");
        doc.add(p1);
        //点线
        Paragraph p2 = new Paragraph("LEFT");
        p2.add(new Chunk(new DottedLineSeparator()));
        p2.add("R");
        doc.add(p2);
        //下滑线
        LineSeparator UNDERLINE = new LineSeparator(1, 100, null, Element.ALIGN_CENTER, -2);
        Paragraph p3 = new Paragraph("这里是下划线");
        p3.add(UNDERLINE);
        doc.add(p3);



        //设置段落
        Paragraph p = new Paragraph("In the previous example, you added a header and footer with the showTextAligned() method. This example demonstrates that it’s sometimes more interesting to use PdfPTable and writeSelectedRows(). You can define a bottom border for each cell so that the header is underlined. This is the most elegant way to add headers and footers, because the table mechanism allows you to position and align lines, images, and text.");

        //默认
        p.setAlignment(Element.ALIGN_JUSTIFIED);
        doc.add(p);
        //根据默认调整后的样式
        doc.newPage();
        p.setAlignment(Element.ALIGN_JUSTIFIED);
        p.setIndentationLeft(1 * 15f);
        p.setIndentationRight((5 - 1) * 15f);
        doc.add(p);

        //居右
        doc.newPage();
        p.setAlignment(Element.ALIGN_RIGHT);
        p.setSpacingAfter(15f);
        doc.add(p);

        //居左
        doc.newPage();
        p.setAlignment(Element.ALIGN_LEFT);
        p.setSpacingBefore(15f);
        doc.add(p);

        //居中
        doc.newPage();
        p.setAlignment(Element.ALIGN_CENTER);
        p.setSpacingAfter(15f);
        p.setSpacingBefore(15f);
        doc.add(p);

        doc.newPage();
        //目类
        // Code 1
        doc.add(new Chunk("Chapter 1").setLocalDestination("1"));
        doc.newPage();
        doc.add(new Chunk("Chapter 2").setLocalDestination("2"));
        doc.add(new Paragraph(new Chunk("Sub 2.1").setLocalDestination("2.1")));
        doc.add(new Paragraph(new Chunk("Sub 2.2").setLocalDestination("2.2")));
        doc.newPage();
        doc.add(new Chunk("Chapter 3").setLocalDestination("3"));
        doc.newPage();
        // Code 2
        PdfContentByte cb = writer.getDirectContent();
        PdfOutline root = cb.getRootOutline();
        // Code 3
        @SuppressWarnings("unused")
        PdfOutline oline1 = new PdfOutline(root, PdfAction.gotoLocalPage("1", false), "Chapter 1");
        PdfOutline oline2 = new PdfOutline(root, PdfAction.gotoLocalPage("2", false), "Chapter 2");
        oline2.setOpen(false);
        @SuppressWarnings("unused")
        PdfOutline oline2_1 = new PdfOutline(oline2, PdfAction.gotoLocalPage("2.1", false), "Sub 2.1");
        @SuppressWarnings("unused")
        PdfOutline oline2_2 = new PdfOutline(oline2, PdfAction.gotoLocalPage("2.2", false), "Sub 2.2");
        @SuppressWarnings("unused")
        PdfOutline oline3 = new PdfOutline(root, PdfAction.gotoLocalPage("3", false), "Chapter 3");
        //******目录到这里******


        //页眉页脚
        writer.setPageEvent(new PdfPageEventHelper() {
            public void onEndPage(PdfWriter writer, Document document) {
                PdfContentByte cb = writer.getDirectContent();
                cb.saveState();
                cb.beginText();
                BaseFont bf = null;
                try {
                    bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, BaseFont.EMBEDDED);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                cb.setFontAndSize(bf, 10);
                //Header
                float x = document.top(-20);

                //左
                cb.showTextAligned(PdfContentByte.ALIGN_LEFT,
                        "H-Left",
                        document.left(), x, 0);
                //中
                cb.showTextAligned(PdfContentByte.ALIGN_CENTER,
                        writer.getPageNumber()+ " page",
                        (document.right() + document.left())/2,
                        x, 0);
                //右
                cb.showTextAligned(PdfContentByte.ALIGN_RIGHT,
                        "H-Right",
                        document.right(), x, 0);

                //Footer
                float y = document.bottom(-20);

                //左
                cb.showTextAligned(PdfContentByte.ALIGN_LEFT,
                        "F-Left",
                        document.left(), y, 0);
                //中
                cb.showTextAligned(PdfContentByte.ALIGN_CENTER,
                        writer.getPageNumber()+" page",
                        (document.right() + document.left())/2,
                        y, 0);
                //右
                cb.showTextAligned(PdfContentByte.ALIGN_RIGHT,
                        "F-Right",
                        document.right(), y, 0);
                cb.endText();
                cb.restoreState();
            }
        });
        doc.open();
        doc.add(new Paragraph("1 page"));
        doc.newPage();
        doc.add(new Paragraph("2 page"));
        doc.newPage();
        doc.add(new Paragraph("3 page"));
        doc.newPage();
        doc.add(new Paragraph("4 page"));
        //左右文字
//        PdfWriter writes = PdfWriter.getInstance(doc, out);
        doc.open();
        PdfContentByte canvas = writer.getDirectContent();
        System.out.println(canvas);
        Phrase phrase1 = new Phrase("left-left-left-left-left-left");
        Phrase phrase2 = new Phrase("rigth-rigth-rigth-rigth-rigth");
        Phrase phrase3 = new Phrase("center-center-center-center-center");
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrase1, 10, 500, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_RIGHT, phrase2, 10, 536, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, phrase3, 10, 572, 0);












        doc.close();








    }
}
