/*package com.wsq.jhone.webmagic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.processor.example.GithubRepoPageProcessor;

public class MyWebMagic implements PageProcessor {
	private final Logger logger = LoggerFactory.getLogger(MyWebMagic.class);
	private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

	@Override
	public Site getSite() {
		logger.info("开始执行爬虫命令-------------------------");

		return site;
	}

	@Override
	public void process(Page arg0) {
		arg0.addTargetRequests(arg0.getHtml().links().regex("(https://github\\.com/\\w+/\\w+)").all());
		arg0.putField("author", arg0.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());
		arg0.putField("name", arg0.getHtml().xpath("//h1[@class='entry-title public']/strong/a/text()").toString());
		// 判断如果返回的name为空/null，那么就跳过
		if (arg0.getResultItems().get("name") == null) {
			arg0.setSkip(true);
		}
		arg0.putField("readme", arg0.getHtml().xpath("//div[@id='readme']/tidyText()"));
	}

	public static void main(String[] args) {
		System.out.println("-----------------" + new MyWebMagic().getSite());
		Spider.create(new GithubRepoPageProcessor()).addUrl("https://github.com/code4craft").addPipeline(new JsonFilePipeline("D:\\webmagic\\")).thread(5).run();
		 
		System.out.println("-----------------" + new MyWebMagic().getSite());
	}
}
*/