<%--
  Created by IntelliJ IDEA.
  User: cilu
  Date: 2017/11/1
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="image/jpeg"
         import="java.awt.*,
                 java.awt.image.*,
                 java.util.*,
                 javax.imageio.*"
         pageEncoding="utf-8" %>
<%@ page import="org.apache.commons.lang.RandomStringUtils" %>
<%@ page import="java.io.OutputStream" %>
<%!
    Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255)
            fc = 255;
        if (bc > 255)
            bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }
%>

<%
    out.clear();
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "No-cache");
    response.setDateHeader("Expires", 0);
    int width = 60, height = 20;
    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    Graphics graphics = image.getGraphics();
    Random random = new Random();
    graphics.setColor(getRandColor(200, 250));
    graphics.fillRect(0, 0, width, height);
    graphics.setColor(getRandColor(160, 200));
    graphics.setFont(new Font("Times New Roman", Font.PLAIN, 18));
    for (int i = 0; i < 155; i++) {
        int x = random.nextInt(width);
        int y = random.nextInt(height);
        int x1 = random.nextInt(12);
        int y1 = random.nextInt(12);
        graphics.drawLine(x, y, x + x1, y + y1);
    }

    String sRand = RandomStringUtils.randomAlphanumeric(4);
    for (int i = 0; i < sRand.length(); i++) {
        graphics.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
        graphics.drawString(sRand.charAt(i) + "", 13 * i + 6, 12 + random.nextInt(4));
    }
    session.setAttribute("sRand", sRand);
    graphics.dispose();
    OutputStream output = response.getOutputStream();
    ImageIO.write(image, "JPEG",response.getOutputStream());
    output.flush();
    out.clear();
    out = pageContext.pushBody();
%>
