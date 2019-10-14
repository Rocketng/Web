package edu.uci.ics.crawler4j.examples.basic;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

import org.apache.http.Header;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;


public class BasicCrawler extends WebCrawler {

    private static final Pattern IMAGE_EXTENSIONS = Pattern.compile(".*\\.(bmp|gif|jpg|png)$");

    private final AtomicInteger numSeenImages;

    private AtomicLong count = new AtomicLong(0);

    /**
     * Creates a new crawler instance.
     *
     * @param numSeenImages This is just an example to demonstrate how you can pass objects to crawlers. In this
     * example, we pass an AtomicInteger to all crawlers and they increment it whenever they see a url which points
     * to an image.
     */
    public BasicCrawler(AtomicInteger numSeenImages) {
        this.numSeenImages = numSeenImages;
    }

    /**
     * You should implement this function to specify whether the given url
     * should be crawled or not (based on your crawling logic).
     * 判断指定的url是否应该被抓取
     */
    @Override
    public boolean shouldVisit(Page referringPage, WebURL url) {
        String href = url.getURL().toLowerCase();
        // Ignore the url if it has an extension that matches our defined set of image extensions.
        //如果url的扩展名与我们定义的一组图像扩展名匹配，则忽略该url。
        if (IMAGE_EXTENSIONS.matcher(href).matches()) {
            numSeenImages.incrementAndGet();
            return false;
        }

        // Only accept the url if it is in the "www.ics.uci.edu" domain and protocol is "http".
        //只接受“www.ics.uci.edu”域内的url，协议为“http”。
        //return href.startsWith("https://www.ics.uci.edu/");

//     String pattern = "https://.*\\.163\\.com/.*";    //针对网易新闻
//     String pattern = "https://www.thepaper.cn/.*";   //针对澎湃新闻
//     String pattern = "https://weibo\\.com/.*";         //针对新浪新闻
//     String pattern = "https://wh\\.58\\.com/.*";      //针对58同城
//     String pattern = "https://.*\\.jd\\.com/.*";      //针对京东
//        String pattern = "https://.*\\.taobao\\.com/.*";  //针对淘宝网
 //    String pattern = "https://www\\.chinatimes\\.com/.*?chdtv";    //针对中国时报
//     String pattern = "https://www\\.zaobao\\.com/.*";   //针对联合早报
//        String pattern = "https://www\\.yahoo\\.com/.*";  //针对雅虎新闻
        String pattern = "http://sputniknews\\.cn/.*";
        boolean isMatch = Pattern.matches(pattern,href);
        return isMatch;
    }

    /**
     * This function is called when a page is fetched and ready to be processed
     * by your program.
     * 在获取页面并准备处理页面时调用此函数
     */
    @Override
    public void visit(Page page) {
        int docid = page.getWebURL().getDocid();
        String url = page.getWebURL().getURL();
        String domain = page.getWebURL().getDomain();
        String path = page.getWebURL().getPath();
        String subDomain = page.getWebURL().getSubDomain();
        String parentUrl = page.getWebURL().getParentUrl();
        String anchor = page.getWebURL().getAnchor();

        logger.debug("Docid: {}", docid);
        logger.info("URL: {}", url);
        count.incrementAndGet();   //原子方式自增
        logger.info("file number:{}",count.get());

        logger.debug("Domain: '{}'", domain);
        logger.debug("Sub-domain: '{}'", subDomain);
        logger.debug("Path: '{}'", path);
        logger.debug("Parent page: {}", parentUrl);  //调试使用
        logger.debug("Anchor text: {}", anchor);

        //将url存入文件
        try {
             FileWriter fw = new FileWriter("D://SuoYou.txt", true);
             String c = url+"\t"+"\r\n";
             fw.write(c);
             fw.close();
         } catch (IOException e1) {
             e1.printStackTrace();
             logger.info("{}","写入失败");
        }

        if (page.getParseData() instanceof HtmlParseData) {
            HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
            String text = htmlParseData.getText();
            String html = htmlParseData.getHtml();
            Set<WebURL> links = htmlParseData.getOutgoingUrls();

            logger.debug("Text length: {}", text.length());
            logger.debug("Html length: {}", html.length());
            logger.debug("Number of outgoing links: {}", links.size());
        }

        Header[] responseHeaders = page.getFetchResponseHeaders();
        if (responseHeaders != null) {
            logger.debug("Response headers:");
            for (Header header : responseHeaders) {
                logger.debug("\t{}: {}", header.getName(), header.getValue());
            }
        }

        logger.debug("=============");
    }
}
