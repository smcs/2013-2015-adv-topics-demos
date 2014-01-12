//
//  GLViewController.h
//  Follow the Finger
//
//  Created by Seth Battis on 3/11/11.
//  Copyright __MyCompanyName__ 2011. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "GLView.h"
#import "SBHead.h"

@interface GLViewController : UIViewController <GLViewDelegate>
{
	double spin, target;
	SBHead *sbh;
}
-(void)spin:(double)degrees;

@end
