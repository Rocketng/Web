package edu.uci.ics.crawler4j.examples.basic;

import java.util.concurrent.atomic.AtomicInteger;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

public class BasicCrawlController {

    public static void main(String[] args) throws Exception {
        CrawlConfig config = new CrawlConfig();

        // Set the folder where intermediate crawl data is stored (e.g. list of urls that are extracted from previously
        // fetched pages and need to be crawled later).
        //设置中间抓取数据存储的文件夹(例如，从以前抓取的页面中提取的url列表，需要以后抓取)。
        config.setCrawlStorageFolder("/tmp/crawler4j/");

        // Be polite: Make sure that we don't send more than 1 request per second (1000 milliseconds between requests).
        // Otherwise it may overload the target servers.
        //要有礼貌:确保我们每秒发送的请求不超过一个(请求之间的间隔为1000毫秒)。否则，它可能会使目标服务器超载。
        config.setPolitenessDelay(1000);

        // You can set the maximum crawl depth here. The default value is -1 for unlimited depth.
        //你可以在这里设置最大的爬行深度。对于无限深度，默认值为-1。
        config.setMaxDepthOfCrawling(4);

        // You can set the maximum number of pages to crawl. The default value is -1 for unlimited number of pages.
        //您可以设置要爬行的最大页面数。对于无限数量的页面，默认值为-1。
        config.setMaxPagesToFetch(100000);

        // Should binary data should also be crawled? example: the contents of pdf, or the metadata of images etc
        //是否也应该抓取二进制数据?例如:pdf的内容、图像的元数据等
        config.setIncludeBinaryContentInCrawling(false);

        // Do you need to set a proxy? If so, you can use:
        //需要设置代理吗?如果是，你可以使用:
        // config.setProxyHost("proxyserver.example.com");
        // config.setProxyPort(8080);

        // If your proxy also needs authentication:
        //如果您的代理也需要身份验证：
        // config.setProxyUsername(username); config.getProxyPassword(password);

        // This config parameter can be used to set your crawl to be resumable
        // (meaning that you can resume the crawl from a previously
        // interrupted/crashed crawl). Note: if you enable resuming feature and
        // want to start a fresh crawl, you need to delete the contents of
        // rootFolder manually.
        //这个配置参数可以用来设置你的爬网是可恢复的
        //(这意味着你可以从以前的一个页面恢复抓取
        // 中断/撞爬)。注意:如果启用了恢复功能
        // 想要重新开始抓取，你需要删除的内容
        // 手动rootFolder。
        config.setResumableCrawling(false);

        // Set this to true if you want crawling to stop whenever an unexpected error
        // occurs. You'll probably want this set to true when you first start testing
        // your crawler, and then set to false once you're ready to let the crawler run
        // for a long time.
        //如果您希望在出现意外错误时停止爬行，请将此设置为true
        //发生。当您第一次开始测试时，您可能希望这个设置为true
        //你的爬虫，然后设置为假一旦你准备好让爬虫运行
        //很长时间了。
        config.setHaltOnError(false);

        // Instantiate the controller for this crawl.
        //为这次抓取实例化控制器。
        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);

        // For each crawl, you need to add some seed urls. These are the first
        // URLs that are fetched and then the crawler starts following links
        // which are found in these pages
        //对于每次抓取，您需要添加一些种子url。这些是第一批
        //获取的url，然后爬虫开始跟随链接
        //在这些页面中可以找到
 //       controller.addSeed("https://news.163.com/");   //首页
 //       controller.addSeed("http://sports.163.com/");  //体育新闻
//        controller.addSeed("https://war.163.com/");    //军事新闻
//        controller.addSeed("https://www.thepaper.cn/");    //澎湃新闻
 //       controller.addSeed("https://weibo.com/ttarticle/p/show?id=2309404424762444087344");  //新浪微博
 //       controller.addSeed("https://wh.58.com/");  //58同城
 //       controller.addSeed("https://www.jd.com/");   //京东网
 //       controller.addSeed("https://www.taobao.com/");    //淘宝网
 //      controller.addSeed("https://www.chinatimes.com/?chdtv");  //中国时报（台湾）
 //       controller.addSeed("https://www.zaobao.com/");   //联合早报（新加坡）
 //       controller.addSeed("https://www.yahoo.com/");
        controller.addSeed("http://sputniknews.cn/archive/");   //所有新闻



        // Number of threads to use during crawling. Increasing this typically makes crawling faster. But crawling
        // speed depends on many other factors as well. You can experiment with this to figure out what number of
        // threads works best for you.
        //爬行期间使用的线程数。增加这个值通常会使爬行速度更快。但爬行
        //速度还取决于许多其他因素。你可以用这个实验来算出
        //最适合你的线程。
        int numberOfCrawlers = 8;

        // To demonstrate an example of how you can pass objects to crawlers, we use an AtomicInteger that crawlers
        // increment whenever they see a url which points to an image.
        //为了演示如何将对象传递给爬虫程序，我们使用了一个AtomicInteger来实现爬虫程序
        //每当他们看到一个指向一个图像的url时递增。
        AtomicInteger numSeenImages = new AtomicInteger();

        // The factory which creates instances of crawlers.
        //创建爬虫实例的工厂。
        CrawlController.WebCrawlerFactory<BasicCrawler> factory = () -> new BasicCrawler(numSeenImages);

        //logger.info("file number:{}",numSeenImages);

        // Start the crawl. This is a blocking operation, meaning that your code
        // will reach the line after this only when crawling is finished.
        //开始爬。这是一个阻塞操作，意思是你的代码
        //只有在爬行完成后才会到达该线。
        controller.start(factory, numberOfCrawlers);
    }

}